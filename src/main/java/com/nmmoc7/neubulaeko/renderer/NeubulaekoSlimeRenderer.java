package com.nmmoc7.neubulaeko.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.nmmoc7.neubulaeko.RenderUtils;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import com.nmmoc7.neubulaeko.model.NeubulaekoSlimeModel;
import com.nmmoc7.neubulaeko.model.Textures;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;

/**
 * @author DustW
 */
public class NeubulaekoSlimeRenderer extends EntityRenderer<NeubulaekoSlimeEntity> {
    private final NeubulaekoSlimeModel neubulaekoSlimeModel = new NeubulaekoSlimeModel();

    public NeubulaekoSlimeRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(NeubulaekoSlimeEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        RenderUtils.openBlendA();
        neubulaekoSlimeModel.render(matrixStackIn,
                bufferIn.getBuffer(neubulaekoSlimeModel.getRenderType(Textures.SLIME_TEXTURES)),
                packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1);
        RenderUtils.closeBlend();
        matrixStackIn.pop();
    }

    @Override
    public boolean shouldRender(NeubulaekoSlimeEntity livingEntityIn, ClippingHelper camera, double camX, double camY, double camZ) {
        return camera.isBoundingBoxInFrustum(livingEntityIn.getRenderBoundingBox());
    }

    @Override
    public ResourceLocation getEntityTexture(NeubulaekoSlimeEntity entity) {
        return Textures.SLIME_TEXTURES;
    }
}
