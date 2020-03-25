/* 用户表 */
CREATE TABLE `dianping`.`user`  (
  `id` int(0) NOT NULL,
  `created_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `telphone` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL,
  `nick_name` varchar(40) NOT NULL,
  `gender` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `telphone_unique_index`(`telphone`) USING BTREE;
);

/* 商户表 */
CREATE TABLE `dianping`.`seller`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL DEFAULT '',
  `created_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `remark_score` decimal(2, 1) NOT NULL COMMENT '评分,0.0-9.9',
  `disabled_flag` int(255) NOT NULL DEFAULT 0 COMMENT '0代表启用',
  PRIMARY KEY (`id`)
);

/* 品类 */
CREATE TABLE `dianping`.`category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `name` varchar(20) NOT NULL,
  `icon_url` varchar(255) NOT NULL,
  `sort ` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_unique_in`(`name`) USING BTREE
);

/* 门店 */
CREATE TABLE `dianping`.`shop`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `updated_at` datetime(0) NOT NULL DEFAULT '1970-01-01 08:00:00',
  `name` varchar(80) NOT NULL DEFAULT '',
  `remark_score` decimal(2, 1) NOT NULL,
  `price_per_man` int(0) NOT NULL,
  `latitude` decimal(10, 6) NOT NULL,
  `longitude` decimal(10, 6) NOT NULL,
  `category_id` int(0) NOT NULL,
  `tags` varchar(2000) NOT NULL DEFAULT '',
  `start_time` varchar(200) NOT NULL DEFAULT '',
  `end_time` varchar(200) NOT NULL DEFAULT '',
  `address` varchar(200) NOT NULL DEFAULT '',
  `seller_id` int(0) NOT NULL,
  `icon_url` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);