package com.arreme.mtt3.domain.tileentities;

import com.arreme.mtt3.domain.blocks.ExampleChestBlock;
import com.arreme.mtt3.domain.containers.ExampleChestContainer;
import com.arreme.mtt3.register.inits.TileEntityInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.StoneButtonBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.IProperty;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ExampleChestTileEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> chestContent = NonNullList.withSize(36,ItemStack.EMPTY);
    protected int numPlayersUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

    public ExampleChestTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ExampleChestTileEntity() {
        this(TileEntityInit.EXAMPLE_CHEST.get());
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.example_chest");
    }


    @Override
    public NonNullList<ItemStack> getItems() {
        return this.chestContent;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContent = itemsIn;
    }

    @Override
    public int getSizeInventory() {
        return 36;
    }

    @Nullable
    @Override
    public Container createMenu(int id, PlayerInventory player) {
        return new ExampleChestContainer(id,player,this);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound,this.chestContent);
        }
        return compound;
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.chestContent = NonNullList.withSize(this.getSizeInventory(),ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound,this.chestContent);
        }
    }

    private void playSound(SoundEvent event) {
        double dx = pos.getX() + 0.5;
        double dy = pos.getZ() + 0.5;
        double dz = pos.getZ() + 0.5;
        this.world.playSound(null, dx,dy,dz, event, SoundCategory.BLOCKS,0.5f,this.world.rand.nextFloat()*0.1f+0.9f);
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        }
        return super.receiveClientEvent(id,type);
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            numPlayersUsing++;
            onOpenOrClose();
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            this.numPlayersUsing--;
            onOpenOrClose();
        }
    }

    private void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof ExampleChestBlock) {
            this.world.addBlockEvent(pos,block,1,numPlayersUsing);
            this.world.notifyNeighborsOfStateChange(pos,block);
        }

    }

    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
    }

    public static int getPlayersUsing(IBlockReader reader,BlockPos pos) {
        BlockState state = reader.getBlockState(pos);
        if (state.hasTileEntity()) {
            TileEntity tileEntity = reader.getTileEntity(pos);
            if (tileEntity instanceof ExampleChestTileEntity) {
                return ((ExampleChestTileEntity) tileEntity).numPlayersUsing;
            }
        }
        return 0;
    }

    public static void swapContent(ExampleChestTileEntity tileEntity, ExampleChestTileEntity otherTe) {
        NonNullList<ItemStack> list = tileEntity.getItems();
        tileEntity.setItems(otherTe.getItems());
        otherTe.setItems(list);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if (this.itemHandler != null) {
            itemHandler.invalidate();
            itemHandler = null;
        }
    }

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHandler.cast();
        }
        return super.getCapability(cap,side);
    }

    @Override
    public void remove() {
        super.remove();
        if (itemHandler != null) {
            itemHandler.invalidate();
        }
    }
}
