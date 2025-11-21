package sweetskylia.a_christmas_tale.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.entity.custom.ReindeerEntity;

public class ReindeerRenderer extends MobEntityRenderer<ReindeerEntity, ReindeerModel<ReindeerEntity>> {


    public ReindeerRenderer(EntityRendererFactory.Context context) {
        super(context, new ReindeerModel<>(context.getPart(ReindeerModel.REINDEER_LAYER)), 0.4f);
    }

    @Override
    public Identifier getTexture(ReindeerEntity entity) {
        return Identifier.of(AChristmasTale.MOD_ID, "textures/entity/reindeer/reindeer.png");
    }

    @Override
    public void render(ReindeerEntity livingEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
