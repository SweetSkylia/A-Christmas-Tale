package sweetskylia.a_christmas_tale.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import sweetskylia.a_christmas_tale.AChristmasTale;
import sweetskylia.a_christmas_tale.entity.custom.ReindeerEntity;

public class ReindeerModel<T extends ReindeerEntity> extends SinglePartEntityModel<T> {

    public static final EntityModelLayer REINDEER_LAYER = new EntityModelLayer(Identifier.of(AChristmasTale.MOD_ID, "reindeer"), "main");


    private final ModelPart root;
    private final ModelPart reindeer;
    private final ModelPart upper;
    private final ModelPart head;
    private final ModelPart horns;
    private final ModelPart lower;
    private final ModelPart frontleg1;
    private final ModelPart frontleg2;
    private final ModelPart backleg1;
    private final ModelPart backlag2;
    private final ModelPart middle;
    private final ModelPart tail;
    public ReindeerModel(ModelPart root) {
        this.root = root.getChild("root");
        this.reindeer = this.root.getChild("reindeer");
        this.upper = this.reindeer.getChild("upper");
        this.head = this.upper.getChild("head");
        this.horns = this.head.getChild("horns");
        this.lower = this.reindeer.getChild("lower");
        this.frontleg1 = this.lower.getChild("frontleg1");
        this.frontleg2 = this.lower.getChild("frontleg2");
        this.backleg1 = this.lower.getChild("backleg1");
        this.backlag2 = this.lower.getChild("backlag2");
        this.middle = this.reindeer.getChild("middle");
        this.tail = this.middle.getChild("tail");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        ModelPartData reindeer = root.addChild("reindeer", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData upper = reindeer.addChild("upper", ModelPartBuilder.create(), ModelTransform.pivot(-1.0F, -15.0F, 5.0F));

        ModelPartData neck_r1 = upper.addChild("neck_r1", ModelPartBuilder.create().uv(22, 26).cuboid(0.0F, -8.0F, 0.0F, 3.0F, 8.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.2182F, 0.0F, 0.0F));

        ModelPartData head = upper.addChild("head", ModelPartBuilder.create().uv(0, 26).cuboid(-1.0F, -12.0F, 1.0F, 5.0F, 6.0F, 6.0F, new Dilation(0.0F))
                .uv(50, 0).cuboid(0.0F, -9.0F, 7.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData horns = head.addChild("horns", ModelPartBuilder.create(), ModelTransform.pivot(1.0F, -13.0F, 2.0F));

        ModelPartData horns_r1 = horns.addChild("horns_r1", ModelPartBuilder.create().uv(0, 38).cuboid(1.0F, -7.0F, -2.0F, 0.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, 1.0F, -1.0F, 0.3927F, -0.6109F, -0.8727F));

        ModelPartData horns_r2 = horns.addChild("horns_r2", ModelPartBuilder.create().uv(0, 38).cuboid(0.0F, -7.0F, -2.0F, 0.0F, 9.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(3.0F, 0.0F, 0.0F, 0.3927F, 0.6109F, 0.8727F));

        ModelPartData lower = reindeer.addChild("lower", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData frontleg1 = lower.addChild("frontleg1", ModelPartBuilder.create().uv(12, 41).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -10.0F, 8.0F));

        ModelPartData frontleg2 = lower.addChild("frontleg2", ModelPartBuilder.create().uv(24, 41).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -10.0F, 8.0F));

        ModelPartData backleg1 = lower.addChild("backleg1", ModelPartBuilder.create().uv(36, 41).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(2.0F, -10.0F, -6.0F));

        ModelPartData backlag2 = lower.addChild("backlag2", ModelPartBuilder.create().uv(48, 41).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 10.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(-1.0F, -10.0F, -6.0F));

        ModelPartData middle = reindeer.addChild("middle", ModelPartBuilder.create().uv(0, 0).cuboid(-3.0F, -18.0F, -8.0F, 7.0F, 8.0F, 18.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

        ModelPartData tail = middle.addChild("tail", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -17.0F, -9.0F));

        ModelPartData tail_r1 = tail.addChild("tail_r1", ModelPartBuilder.create().uv(50, 6).cuboid(-2.0F, -3.0F, -1.0F, 3.0F, 3.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.6109F, 0.6981F, 0.0F));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, int color) {
        root.render(matrices, vertexConsumer, light, overlay, color);
//        lower.render(matrices, vertexConsumer, light, overlay,color);
    }


    @Override
    public void setAngles(ReindeerEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.getPart().traverse().forEach(ModelPart::resetTransform);
        this.setHeadAngles(netHeadYaw,headPitch);

        this.animateMovement(ReindeerAnimation.ANIM_REINDEER_WALKING, limbSwing,limbSwingAmount, 2f, 2.5f);
        this.updateAnimation(entity.idleAnimationState, ReindeerAnimation.ANIM_REINDEER_IDLE, ageInTicks,1f);
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    private void setHeadAngles(float headYaw, float headPitch) {
        headYaw = MathHelper.clamp(headYaw, -30f,30f);
        headPitch = MathHelper.clamp(headPitch, -25f,45f);

        this.upper.yaw = headYaw * 0.017453292F;
        this.upper.pitch = headPitch * 0.017453292F;
    }


}
