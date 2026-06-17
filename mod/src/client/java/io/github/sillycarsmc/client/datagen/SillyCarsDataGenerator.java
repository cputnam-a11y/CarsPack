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

package io.github.sillycarsmc.client.datagen;

import io.github.sillycarsmc.client.datagen.assets.SillyCarsModelProvider;
import io.github.sillycarsmc.client.datagen.data.SillyCarsBlockLootTableProvider;
import io.github.sillycarsmc.client.datagen.data.SillyCarsRecipeProvider;
import io.github.sillycarsmc.client.datagen.data.tags.SillyCarsBlockTagProvider;
import io.github.sillycarsmc.client.datagen.data.tags.SillyCarsItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

@SuppressWarnings("unused")
public final class SillyCarsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(final FabricDataGenerator fabricDataGenerator) {
		final var pack = fabricDataGenerator.createPack();
		pack.addProvider(SillyCarsItemTagProvider::new);
		pack.addProvider(SillyCarsBlockTagProvider::new);
		pack.addProvider(SillyCarsRecipeProvider::new);
		pack.addProvider(SillyCarsBlockLootTableProvider::new);
		pack.addProvider(SillyCarsModelProvider::new);
	}
}
