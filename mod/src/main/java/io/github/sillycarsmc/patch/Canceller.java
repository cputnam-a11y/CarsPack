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

package io.github.sillycarsmc.patch;

import com.bawnorton.mixinsquared.api.MixinCanceller;

import java.util.List;

public class Canceller implements MixinCanceller {
	@Override
	public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
		// fixed in rrv already, causes a crash because rrv no longer has the target due to the fix
		if (mixinClassName.contains("com.zurrtum.create.client.mixin.BuiltInReliableRecipeViewerClientIntegrationMixin")) return true; // breaks rrv 8.3.1
		return false;
	}
}
