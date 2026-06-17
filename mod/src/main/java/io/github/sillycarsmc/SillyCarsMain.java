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

package io.github.sillycarsmc;

import io.github.sillycarsmc.config.SillyCarsServerConfig;
import io.github.sillycarsmc.content.SillyCarsEvents;
import io.github.sillycarsmc.content.items.SillyCarsItems;
import io.github.sillycarsmc.content.blocks.SillyCarsBlocks;
import net.fabricmc.api.ModInitializer;

public final class SillyCarsMain implements ModInitializer {
	@Override
	public void onInitialize() {
		SillyCarsServerConfig.load();
		SillyCarsBlocks.initialize();
		SillyCarsItems.initialize();
		SillyCarsEvents.initialize();
	}
}
