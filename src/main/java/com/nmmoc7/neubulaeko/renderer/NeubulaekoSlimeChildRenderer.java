package com.nmmoc7.neubulaeko.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeChildEntity;
import com.nmmoc7.neubulaeko.entity.NeubulaekoSlimeEntity;
import com.nmmoc7.neubulaeko.model.NeubulaekoSlimeChildModel;
import com.nmmoc7.neubulaeko.model.Textures;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3f;

/**
 * @author DustW
 */
public class NeubulaekoSlimeChildRenderer extends EntityRenderer<NeubulaekoSlimeChildEntity> {
    private final NeubulaekoSlimeChildModel model = new NeubulaekoSlimeChildModel();

    public NeubulaekoSlimeChildRenderer(EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(NeubulaekoSlimeChildEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        matrixStackIn.push();
        matrixStackIn.scale(0.8f, 0.8f, 0.8f);
        matrixStackIn.rotate(Vector3f.ZN.rotationDegrees(180));
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(this.getEntityTexture(entityIn)));
        model.render(matrixStackIn, ivertexbuilder,
                packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.5F);
        matrixStackIn.pop();
    }

    @Override
    public ResourceLocation getEntityTexture(NeubulaekoSlimeChildEntity entity) {
        return Textures.SLIME_TEXTURES;
    }
}
