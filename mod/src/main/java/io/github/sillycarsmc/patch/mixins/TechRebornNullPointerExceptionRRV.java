package io.github.sillycarsmc.patch.mixins;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.moulberry.mixinconstraints.annotations.IfModLoaded;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.spongepowered.asm.mixin.Mixin;
import techreborn.TechReborn;
import techreborn.items.armor.AttributeModifierBuilder;
@IfModLoaded("techreborn")
@Mixin(AttributeModifierBuilder.class)
public class TechRebornNullPointerExceptionRRV {
	@WrapMethod(
		method = "equals"
	)
	private static boolean catchNullPointer(ItemAttributeModifiers attributes, ItemAttributeModifiers target, Operation<Boolean> original) {
		try {
			return original.call(attributes, target);
		} catch (NullPointerException e) {
			TechReborn.LOGGER.warn("Caught NullPointerException in AttributeModifierBuilder#equals", e);
			return false;
		}
	}
}
