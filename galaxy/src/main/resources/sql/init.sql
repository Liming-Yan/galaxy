-- ----------------------------
-- 星体分类表
-- ----------------------------
DROP TABLE IF EXISTS `star_type`;
CREATE TABLE `star_type`  (
  `id`   int         NOT NULL AUTO_INCREMENT comment 'id',
  `type` varchar(32) NOT NULL comment '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB comment = '星体分类表';

-- ----------------------------
-- 星体详情表
-- ----------------------------
DROP TABLE IF EXISTS `star_details_info`;
CREATE TABLE `star_details_info`  (
  `id`              int           NOT NULL AUTO_INCREMENT comment 'id',
  `name`            varchar(32)   NOT NULL                comment '名称',
  `typeId`          int           NOT NULL                comment '类型id',
  `simple_desc`     varchar(64)   NOT NULL                comment '简要描述',
  `detailed_desc`   varchar(128)  NOT NULL                comment '详细描述',
  `thumbnail`       varchar(128)  NOT NULL                comment '缩略图url',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB comment = '星体详情表';
