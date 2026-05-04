package io.github.Ferbmicah.onebuttondoorbells.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.JukeboxPlayable;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.JukeboxBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class JukeButton extends ButtonBlock {

	private SoundEvent Song;

	public JukeButton(BlockSetType type, int ticksToStayPressed, Properties properties, SoundEvent song) {
		super(type, ticksToStayPressed, properties);
		Song = song;
	}

	@Override
	public void press(final BlockState state, final Level level, final BlockPos pos, final @Nullable Player player) {
		super.press(state,level,pos,player);
		this.playJukeboxSound(player, level, pos, true);
	}

	protected void playJukeboxSound(final @Nullable Player player, final LevelAccessor level, final BlockPos pos, final boolean pressed) {
		level.playSound(player, pos, Song, SoundSource.RECORDS);
	}

}
