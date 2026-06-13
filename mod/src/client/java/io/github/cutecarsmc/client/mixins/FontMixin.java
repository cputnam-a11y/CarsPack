/*
 * CuteCars
 * meow moew mod
 *
 * Copyright (c) 2026 CuteCars Authors
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program. If not, see
 * <https://www.gnu.org/licenses/>.
 */

package io.github.cutecarsmc.client.mixins;

import io.github.cutecarsmc.client.config.CuteCarsClientConfig;
import io.github.cutecarsmc.utils.uwuify.UwuifiedCharSequence;
import io.github.cutecarsmc.utils.uwuify.Uwuifier;
import net.minecraft.client.gui.Font;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Font.class)
abstract class FontMixin {
	@ModifyVariable(method = "width(Ljava/lang/String;)I", at = @At("LOAD"), argsOnly = true)
	private static String cutecars$uwuify(final String original) {
		return CuteCarsClientConfig.instance().enableUwuification ? Uwuifier.uwuify(original) : original;
	}

	@ModifyVariable(method = "width(Lnet/minecraft/util/FormattedCharSequence;)I", at = @At("LOAD"), argsOnly = true)
	private static FormattedCharSequence cutecars$uwuify(final FormattedCharSequence original) {
		return CuteCarsClientConfig.instance().enableUwuification ? new UwuifiedCharSequence(original) : original;
	}
}
