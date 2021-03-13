package net.luis.survive.init.capability;

import java.util.concurrent.Callable;

import net.luis.survive.api.capability.BackpackItemStackHandler;
import net.luis.survive.api.capability.IBackpackItemHandler;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;

public class BackpackCapability {
	
	@CapabilityInject(IBackpackItemHandler.class)
	public static Capability<IBackpackItemHandler> BACKPACK = null;
	
	public static Capability<IBackpackItemHandler> getBackpack() {
		
		return BACKPACK;
		
	}
	
	public static Capability<IBackpackItemHandler> setBackpack() {
		
		return BACKPACK;
		
	}
	
	public static class BackpackStorage implements IStorage<IBackpackItemHandler> {
		@Override
		public INBT writeNBT(Capability<IBackpackItemHandler> capability, IBackpackItemHandler instance, Direction side) {
			return null;
		}
		@Override
		public void readNBT(Capability<IBackpackItemHandler> capability, IBackpackItemHandler instance, Direction side, INBT nbt) {
		}
	}
	
	public static class BackpackFactory implements Callable<IBackpackItemHandler> {
		@Override
		public IBackpackItemHandler call() throws Exception {
			return null;
		}
	}
	
	public static class BackpackProvider implements ICapabilitySerializable<CompoundNBT> {
		
		private BackpackItemStackHandler inventory = new BackpackItemStackHandler(38);
		private LazyOptional<IItemHandlerModifiable> optional = LazyOptional.of(() -> inventory);
		
		@Override
		@SuppressWarnings("unchecked")
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			
			return cap == BACKPACK && cap != null ? (LazyOptional<T>) optional : LazyOptional.empty();
			
		}
		
		public void setapability(LazyOptional<IItemHandlerModifiable> optional) {
			
			this.optional = optional;
			
		}

		@Override
		public CompoundNBT serializeNBT() {
			
			return inventory.serializeNBT();
			
		}

		@Override
		public void deserializeNBT(CompoundNBT nbt) {
			
			inventory.deserializeNBT(nbt);
			
		}
		
	}
	
}
