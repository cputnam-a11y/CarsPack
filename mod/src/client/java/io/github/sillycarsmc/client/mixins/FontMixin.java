/*
 * SillyCars
 * meow moew mod
 *
 * Copyright (c) 2026 SillyCars Authors
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

package io.github.sillycarsmc.client.mixins;

import io.github.sillycarsmc.client.config.SillyCarsClientConfig;
import io.github.sillycarsmc.utils.uwuify.UwuifiedCharSequence;
import io.github.sillycarsmc.utils.uwuify.Uwuifier;
import net.minecraft.client.gui.Font;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Font.class)
abstract class FontMixin {
	@ModifyVariable(method = "width(Ljava/lang/String;)I", at = @At("LOAD"), argsOnly = true, name = "str")
	private static String sillycars$uwuify(final String original) {
		return SillyCarsClientConfig.instance().enableUwuification ? Uwuifier.uwuify(original) : original;
	}

	@ModifyVariable(method = "width(Lnet/minecraft/util/FormattedCharSequence;)I", at = @At("LOAD"), argsOnly = true, name = "text")
	private static FormattedCharSequence sillycars$uwuify(final FormattedCharSequence original) {
		return SillyCarsClientConfig.instance().enableUwuification ? new UwuifiedCharSequence(original) : original;
	}
}
