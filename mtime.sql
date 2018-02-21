/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 50150
 Source Host           : localhost:3306
 Source Schema         : mtime

 Target Server Type    : MySQL
 Target Server Version : 50150
 File Encoding         : 65001

 Date: 21/02/2018 15:14:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actor
-- ----------------------------
DROP TABLE IF EXISTS `actor`;
CREATE TABLE `actor`  (
  `actorId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nameCn` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `nameEn` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `story` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '演员简介小传',
  PRIMARY KEY (`actorId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '演员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of actor
-- ----------------------------
INSERT INTO `actor` VALUES (4, '阿米尔·汗', 'img/actor_img/212330.10270744_290X440X4.jpg', 'Aamir Khan', '8岁时出演一部轰动印度全国的电影，是公认的很有前途的童星，但长大后他却坚决不愿从影，而一心去打网球，而且打得还不错，曾经获得过马哈拉施特拉邦的网球冠军。随着年纪的增长，才抛弃网球重回大银幕。阿米尔的罗曼史就是一部电影的好题材。他21岁的时候爱上了邻居家的女孩，但由于宗教原因（女孩家是印度教徒，他是一个正统的穆斯林），两方家长都坚决反对这桩婚事，两个年轻人决定私奔。现在他们过着幸福美满的生活，甚至常常被印度政府和印度政党拿来当作印度教和穆斯林和睦相处的典范。');
INSERT INTO `actor` VALUES (5, '塞伊拉·沃西', 'img/actor_img/093800.70234429_290X440X4.jpg', 'Zaira Wasim', '塞伊拉·沃西出生在印度北部克什米尔的斯利那加，爸爸是经理、妈妈是老师，从小就读当地国际学校。2016年首次出演电影《摔跤吧！爸爸》，扮演女主角吉塔的少年时代，并获得印度National Film Award最佳女配角称号，2017年电影《神秘巨星》中她担当女主角，入围63rd Filmfare Awards最佳女主角。');
INSERT INTO `actor` VALUES (6, '艾伦', 'img/actor_img/155814.95270359_290X440X4.jpg', 'Allen Ai', '艾伦，北京市人，开心麻花签约演员。毕业于北京电影学院表演系。2002年，在上戏校的艾伦第一次登台表演。2004年，出演首部电视剧《搭错车》。2006年，加入开心麻花团队，之后第一次出演开心麻花舞台剧《倒霉阿翔》。2008年，出演由高希希执导的电视剧《男人底线》。');
INSERT INTO `actor` VALUES (7, '马丽', 'img/actor_img/155018.92326154_290X440X4.jpg', 'Li Ma', '马丽，1982年6月28日出生于辽宁丹东，2003年毕业于中央戏剧学院表演系，2004年毕业于北京大学林兆华戏剧研修班，中国大陆影视、话剧女演员。');
INSERT INTO `actor` VALUES (8, '沈腾', 'img/actor_img/105617.72460110_290X440X4.jpg', 'Teng Shen', '沈腾，出生于黑龙江现居北京，2003年毕业于解放军艺术学院，“开心麻花：功勋演员。2003年出演开心麻花第一部舞台剧《想吃麻花现给你拧》，之后九年的时光，他与麻花一起成长，曾主演、导演多部开心麻花爆笑舞台剧。');
INSERT INTO `actor` VALUES (9, '休·杰克曼', 'img/actor_img/210910.39596130_290X440X4.jpg', 'Hugh Jackman', '澳大利亚著名男演员。因在电影《范海辛》中饰演一脸胡渣粗犷扮相的吸血鬼猎人受到了大众的赏识，更因饰演《X战警》系列中的“金刚狼”而闻名，因为饰演金刚狼，他被影迷们亲切的称他为“狼叔”。');
INSERT INTO `actor` VALUES (10, '米歇尔·威廉姆斯', 'img/actor_img/090548.66586657_290X440X4.jpg', 'Michelle Williams', '米歇尔·威廉姆斯出生在美国蒙大拿州的卡利斯比，九岁后搬至加州圣地亚哥。她是家中五个孩子的老大，此外还有一位同父异母的姐姐现是加州一所小学的副校长。米歇尔的父亲莱理·威廉姆斯是期货交易界的第一位和最耀眼的明星');
INSERT INTO `actor` VALUES (11, '扎克·埃夫隆', 'img/actor_img/191508.89302954_290X440X4.jpg', 'Zac Efron', '埃夫隆是因为出演迪斯尼电影《歌舞青春》和《海岸情缘》而被大家所熟知，之后在2007年的《歌舞青春2》及2008年的《歌舞青春3：毕业季》中再次出演男主角Troy Bolton。他是2002年踏入演艺圈的，刚开始只在一些电视剧中扮演以前客串小角色。');
INSERT INTO `actor` VALUES (12, '赞达亚', 'img/actor_img/082027.56533435_290X440X4.jpg', 'Zendaya', 'Zendaya是在加州奥瑞达的莎士比亚剧院长大的，因为她的母亲是剧院里的内务管理，Zendaya帮助妈妈给观众找座位、卖抽彩券。她在奥克兰的艺术学校就读，并主演了一个舞台剧。她也在the CalShakes Conservatory program 和 the American Conservatory Theater 学习表演。');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `adminId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `privilege` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`adminId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '管理员表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'root', 'root', 2);
INSERT INTO `admin` VALUES (2, 'admin', 'admin', 1);

-- ----------------------------
-- Table structure for movie
-- ----------------------------
DROP TABLE IF EXISTS `movie`;
CREATE TABLE `movie`  (
  `movieId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `titleCn` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `titleEn` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `director` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `actors` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `story` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img` varchar(90) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` date NOT NULL,
  PRIMARY KEY (`movieId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '电影信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of movie
-- ----------------------------
INSERT INTO `movie` VALUES (6, '羞羞的铁拳 (2017)', 'Never Say Die', '宋阳 张吃鱼', '艾伦 马丽 沈腾', '艾伦饰演的靠打假拳混日子的艾迪生，和马丽饰演的正义感十足的体育记者马小，本来是一对冤家。但因为一场意外的电击，两人的身体发生了互换。之后两人“互坑互害”，引发拳坛“大地震”，揭开了假拳界的秘密，随之也引来了一堆麻烦。', '喜剧', 'img/movie_img/103358.62266932_270X405X4.jpg', '2017-09-30');
INSERT INTO `movie` VALUES (7, '灿烂这一刻 (2017)', 'Shining Moment', '陈果', '张敬轩 郝蕾 林雪', '农村出身的拉丁舞老师余梦辉在被要求比赛夺冠的压力下，带领着一群水平参差不齐的小朋友严格训练，刻苦排练。比赛结果却以失败告终，余老师还被家长揍了一顿。心灰意冷的他回到了农村的菠萝园，不料却被独自前来找他依然不肯放弃比赛的小朋友们感动，在舞厅老板蓝姨的说动下，他决定带着小朋友们重回舞台，去迎接一场真人秀的挑战。', '剧情', 'img/movie_img/163529.82395176_270X405X4.jpg', '2017-11-24');
INSERT INTO `movie` VALUES (8, '我的爸爸是森林之王 (2017)', 'The Son of Bigfoot', 'Jeremy Degruson 本·斯塔森', 'Chris Parson 辛达·亚当斯 Bob Barlen 卡尔·布伦克尔', '13岁的少年亚当，父亲早逝跟着妈妈长大，无法与同学好好交流的他一心想要逃离学校生活。一次偶然的机会，他发现了母亲隐瞒已久的秘密，原来他的父亲还在人世。亚当义无反顾的踏上前去寻找父亲之路，却意外的混入了原始森林中，发现父亲居然是拥有超能力的森林之王！而亚当竟然也遗传了父亲的基因，拥有超能力！就在一家人即将团聚的时候，一个巨大的阴谋正在靠近……父子二人能同心协力度过难关吗？', '动画/喜剧', 'img/movie_img/151023.83293516_270X405X4.jpg', '2017-10-14');
INSERT INTO `movie` VALUES (9, '十八洞村 (2017)', 'Hold Your Hands', '苗月', '王学圻 陈瑾 白威 陈西贝', '十八洞村退伍老兵杨英俊和几个堂兄弟家均为精准识别的贫困户，面对现状，他们虽心态各异，但是内心深处都有改变命运的期盼。在扶贫工作队的帮扶下，杨英俊带领杨家兄弟立志、立身、立行，决心打一场脱贫攻坚战，在追求生活脱贫的过程中，他们完成了一次精神上的脱贫。', '剧情', 'img/movie_img/163529.82395176_270X405X4.jpg', '2017-10-12');
INSERT INTO `movie` VALUES (10, '我心雀跃 (2017)', 'My Heart Leaps Up', '刘紫微', '孙伊涵 宋宁 周楚楚 杜双宇', '高二女生刘唯唯在学校结识了美术老师邹野，邹野独特的气质和举止让她第一次有了怦然心动的感觉，纵使这份藏不住的懵懂情愫无法抑制，青春期少女特有的大胆和 自以为是让刘唯唯沉浸在自己想象中的感情互动里无法自拔……在那一年夏天，她就像一个闪亮的发光体，无所顾忌地去做自己喜欢的事，去爱自己喜欢的人。', '爱情/剧情', 'img/movie_img/152107.55307864_270X405X4.jpg', '2017-06-09');
INSERT INTO `movie` VALUES (11, '密战 (2017)', 'Eternal Wave', '钟少雄', '郭富城 赵丽颖 张翰 任达华', '淞沪会战后上海沦陷，地下工作者林翔（郭富城饰）受命来到危机四伏的上海，重建惨遭敌人破坏的地下抗日战线。在这里他遇到单纯却很有正义感的兰芳（赵丽颖饰），这对临时组成的“地下党夫妇”将在战火纷飞中，携手亦正亦邪的梁栋（张翰饰）与日本侵略者及伪政府特务展开惊险刺激的生死较量……', '战争/动作/剧情', 'img/movie_img/095100.77301075_270X405X4.jpg', '2017-11-03');
INSERT INTO `movie` VALUES (12, '鲨海 (2017)', '47 Meters Down', '约翰内斯·罗伯茨', '曼迪·摩尔 马修·莫迪恩 克莱尔·霍尔特', 'Lisa和Kate两姐妹在墨西哥海岸度假，她们在海底观鲨铁笼中潜水观赏鲨鱼时，牵连铁笼的绳子突然断裂，观鲨笼掉落到47米深的海底。由于所存氧气不多，她们只有一个小时的时间逃脱牢笼回到水面。而此时，大白鲨也在她们周围游弋着。47米深的海底一片漆黑，只能通过手电筒观察铁笼外面的情况。水面上工作人员的声音时有时无，救援队也迟迟不见踪影，姐妹俩都非常害怕。面对仅剩的氧气。。。', '冒险/剧情/恐怖', 'img/movie_img/081658.33840819_270X405X4.jpg', '2017-12-08');
INSERT INTO `movie` VALUES (13, '缝纫机乐队 (2017)', 'City Of Rock', '大鹏', '大鹏 乔杉 娜扎 李鸿其', '在大鹏的家乡小镇集安，几个背景各异的小人物为了追寻共同的音乐梦想，组建了一只不同寻常的摇滚乐队。几个人在追梦之路上经历了接二连三的波折，也发生了一系列让人啼笑皆非的意外。', '喜剧/剧情', 'img/movie_img/112831.50815325_270X405X4.jpg', '2017-09-29');
INSERT INTO `movie` VALUES (14, '暴雪将至 (2017)', 'The Looming Storm', '董越', '段奕宏 江一燕 杜源 郑伟', '上世纪九十年代某个小城，天气预报中一场百年不遇的暴雪即将侵袭此地，人心惶惶时骤然发生了一起残忍的连环杀人案。一心想进入体制内的保卫科干事余国伟（段奕宏饰）渴望借此机会，一展自己颇为得意的“神探”技能，并破格进入体制内成为真正的警察及模范。面对“探案”欲望与燕子（江一燕饰）的感情，余神探越陷越深，付出的代价也越来越大。然而宿命因果，万事皆有定数……', '剧情/悬疑/犯罪', 'img/movie_img/094700.31523866_270X405X4.jpg', '2017-11-17');
INSERT INTO `movie` VALUES (15, '全球风暴 (2017)', 'Geostorm', '迪安·德夫林', '杰拉德·巴特勒 吉姆·斯特吉斯 艾比·考尼什 艾德·哈里斯', '在一系列史无前例的自然灾害席卷地球之后，全球领袖携手创建了一个复杂的卫星网络来控制全球气候并保证所有人的安全。但现在，本该保护地球的系统却出了错，开始攻击地球，要赶在一场席卷整个世界的全球风暴摧毁一切前发现真正的威胁', '动作/科幻/惊悚', 'img/movie_img/110308.10642474_270X405X4.jpg', '2017-10-27');
INSERT INTO `movie` VALUES (16, '精灵宝可梦：波尔凯尼恩与机巧的玛机雅娜 (2016)', 'Pokémon the Movie : Volcanion and the Ingenious Magearna', '汤山邦彦', '松本梨香 大谷育江 市川染五郎 寺崎裕香', '小智和皮卡丘等一行伙伴在旅途中前行。某日，宝可梦波尔凯尼恩从天而降并被迫与小智锁在了一起。波尔凯尼恩与被人类伤害过的宝可梦们共同生活，因此非常讨厌人类，但这条神奇的锁链却让他们无法分开，奇妙的故事就此开始。小智与皮卡丘..', '动画/奇幻/冒险', 'img/movie_img/093030.39560657_270X405X4.jpg', '2017-11-11');
INSERT INTO `movie` VALUES (17, '刺杀盖世太保 (2017)', 'HHhH', '赛德里克·吉门内兹', '杰森·克拉克 裴淳华 杰克·奥康奈尔 米娅·华希科沃斯卡', '青年海德里希（杰森·克拉克饰）在舞会上对女子丽娜（裴淳华饰）一见钟情，并对丽娜的纳粹思想深表赞同。二人婚后，海德里希通过丽娜的帮助成为纳粹党卫军的一员，开始大肆虐杀犹太人，种种暴行让他成为了“类人猿”行动的清除目标。', '剧情/历史/战争', 'img/movie_img/093927.78820642_270X405X4.jpg', '2017-11-24');
INSERT INTO `movie` VALUES (18, '降魔传 (2017)', 'The Golden Monk', '王晶 钟少雄', '郑恺 张雨绮 谢依霖 毛俊杰', '南宋年间，杭州城妖怪肆虐，百姓困苦不堪。玄光寺不通和尚（郑恺饰）下山降妖除魔，邂逅女降魔师菁菁（张雨绮饰）。原来二人前世实为天庭金童玉女，因触犯天条被贬人间，至此已轮回百世，却始终未能相认。不通与菁菁协力铲除天山老..', '奇幻/动作/喜剧', 'img/movie_img/103434.86169309_270X405X4.jpg', '2017-11-17');
INSERT INTO `movie` VALUES (19, '你在哪 (2017)', 'Breathing', '樊昊仑', '景珂 樊昊仑 上白杨晋', '影片讲述了一个普通小城发生多起拐卖儿童重案，危机四伏，丢失孩子的年轻妈妈王楠，独自深入人贩子组织寻找女儿小鱼，与此同时当地警察也获得多起拐卖案件的犯罪线索，千里追凶万里寻子的故事就此展开。', '剧情', 'img/movie_img/165940.84073771_270X405X4.jpg', '2017-11-30');
INSERT INTO `movie` VALUES (20, '恐袭波士顿 (2016)', 'Patriots Day', '彼得·博格', '马克·沃尔伯格 凯文·贝肯 J·K·西蒙斯 米歇尔·莫娜汉', '影片聚焦于2013年的波士顿马拉松爆炸事件，马克·沃尔伯格饰演警长汤米·桑德斯（Tommy Saunders）。他和幸存者、第一线应变人员和调查员一起追捕制造爆炸案的恐怖分子，以防他们再一次袭击。', '剧情/犯罪', 'img/movie_img/114958.39127520_270X405X4.jpg', '2017-11-17');
INSERT INTO `movie` VALUES (21, '不成问题的问题 (2016)', 'Mr.No Problem', '梅峰', '范伟 殷桃 张超 史依弘', '“树华农场”，创办于抗战那年，距重庆市三十多里，坐落在江边小山的半腰，是座常引渡客心驰神往的农场。农场运营三年，虽物产丰富，却在赔钱。而农场股东们对此也是睁一眼闭一眼，因为他们都领略过丁主任的种种好。', '剧情', 'img/movie_img/175148.23346123_270X405X4.jpg', '2017-11-21');
INSERT INTO `movie` VALUES (22, '引爆者 (2017)', 'Explosion', '常征', '段奕宏 余男 王景春', '《引爆者》讲述了段奕宏饰演的男主角赵旭东，无辜被卷入多派势力的利益争夺中，化身孤胆英雄自我救赎的故事。', '动作/犯罪', 'img/movie_img/111645.84805996_270X405X4.jpg', '2017-11-24');
INSERT INTO `movie` VALUES (23, '冒牌监护人之寻宝闹翻天 (2017)', 'Fake Guardians', '陈玮卿', '张一山 笑嘻嘻 张蓝心 谢依霖', '本片讲述的是在繁华的都市中，三个屌丝子初（张一山 饰）、知了（彭波 饰）、立人（段钧豪 饰），由于被李万基（洪剑涛 饰）的建筑公司拖欠的各种薪酬和费用而走到一起，三人同仇敌忾被迫踏上了讨薪讨债之路。', '剧情/喜剧', 'img/movie_img/094232.92949182_270X405X4.jpg', '2017-12-01');
INSERT INTO `movie` VALUES (24, '七十七天 (2017)', 'Seventy-Seven Days', '赵汉唐', '赵汉唐 江一燕', '电影《七十七天》是以探险作家杨柳松77天孤身穿越羌塘无人区的真实 事迹为蓝本创作。电影中，在生活里迷失了自我的男主徘徊在雪域高原 独闯无人区，影片女主身体残疾仍然乐观面对生活，她让他坚定了去尝 试世人眼里无法完成的无人区..', '剧情/冒险', 'img/movie_img/151524.47829199_270X405X4.jpg', '2017-11-03');
INSERT INTO `movie` VALUES (25, '雷神3：诸神黄昏 (2017)', 'Thor: Ragnarok', '塔伊加·维迪提', '克里斯·海姆斯沃斯 凯特·布兰切特 汤姆·希德勒斯顿 马克·鲁法洛', '失去雷霆之锤的索尔被囚禁在宇宙的另一端，他不得不想方设法尽早赶回阿斯加德，阻止家园的毁灭和阿斯加德文明的终结，即所谓的“诸神黄昏”。整个事件背后的主谋是无情的死神海拉，她威力无穷，对整个宇宙造成了全新威胁。', '动作/冒险/喜剧', 'img/movie_img/154744.36955889_270X405X4.jpg', '2017-11-03');
INSERT INTO `movie` VALUES (26, '嘉年华 (2017)', 'Angels Wear White', '文晏', '文淇 周美君 史可 耿乐', '少女小米在海边一家旅店做临时工，碰巧成为在旅店发生的一起少女被性侵案件的唯一知情者。为了保住收入微薄的工作，她决定保持沉默。与此同时，被卷入案件的小文却发现她的麻烦才刚刚开始。　　影片透过两个不同年龄段、不同成长背景下..', '剧情', 'img/movie_img/093115.47270261_270X405X4.jpg', '2017-12-24');
INSERT INTO `movie` VALUES (27, '东方快车谋杀案 (2017)', 'Murder on the Orient Express', '肯尼思·布拉纳', '肯尼思·布拉纳 约翰尼·德普 米歇尔·菲佛', '影片讲述大侦探在东方快车上巧破一桩谋杀奇案的故事。波洛乘上东方快车，夜间三次被吵醒，第二天清晨便发现同车的美国富商雷切尔被人谋杀，死者被戳了12刀。波洛根据他所观察到的各种可疑迹象以及同车人士的讯问', '犯罪/剧情/悬疑', 'img/movie_img/164405.60001643_270X405X4.jpg', '2017-11-10');
INSERT INTO `movie` VALUES (28, '夺金四贱客 (2017)', 'Vier gegen die Bank', '沃尔夫冈·彼德森', '蒂尔·施威格 马提亚斯·施维赫夫 米歇尔·荷比西 让·约瑟夫·莱佛斯', '三个不同背景、性格迥异的男人为了各自毕生的梦想和美好的未来，多年辛苦存钱，他们拥有一个共同的神经质投资顾问。不幸的是，三人账户惨遭清零，投资顾问也因被嫁祸而遭到解雇。四个大男人一同陷入了绝望境地，为此他们结为同盟', '喜剧/犯罪', 'img/movie_img/101425.42455295_270X405X4.jpg', '2017-12-01');
INSERT INTO `movie` VALUES (29, '追捕 (2017)', 'Manhunt', '吴宇森', '张涵予 福山雅治 戚薇', '国际律师杜丘（张涵予 饰）清晨醒来，发现一个陌生女子被杀死在枕边，当所有证据皆指向自己就是凶手时，他拒捕逃离，决定自己查出真相。颇有名气的警探矢村（福山雅治 饰）在追捕过程中，察觉案件并不简单。一警一“匪”在交手中竟发展..', '动作/剧情/犯罪', 'img/movie_img/092729.25192273_270X405X4.jpg', '2017-11-24');
INSERT INTO `movie` VALUES (30, '空难余波 (2017)', 'Aftermath', '艾略特·莱斯特', '阿诺·施瓦辛格 斯科特·麦克奈利 玛姬·格蕾斯', '施瓦辛格所饰演的罗曼在机场满心欢喜等待妻女归来，却最终等来飞机失事的不幸消息。虽然一名航空管制人员承认了自己的工作失职并被警局保护性监禁，但这些仍不能阻止施瓦辛格的复仇行为。', '剧情/惊悚', 'img/movie_img/152612.79852535_270X405X4.jpg', '2017-12-01');
INSERT INTO `movie` VALUES (31, '这就是命 (2017)', 'Kill Me Please', '王丹', '王迅 曾志伟 梁超 潘斌龙', '中年大叔孟大卫（王迅饰）正经历中年危机：和在旅行团做导游的妻子杨晓楠（于莎莎饰）婚姻出现危机；又不幸查出膀胱癌。万念俱灰、正准备跳楼自杀的孟，接到保险公司的推销电话，心生一计，想要设计意外死亡给妻子留下一笔保险赔偿..', '剧情/喜剧', 'img/movie_img/102916.29353605_270X405X4.jpg', '2017-12-01');
INSERT INTO `movie` VALUES (32, '至暗时刻 (2017)', 'Darkest Hour', '乔·赖特', '加里·奥德曼 莉莉·詹姆斯 本·门德尔森 克里斯汀·斯科特·托马斯', '影片将带领观众重返二战时期的1940年，其时，不可阻挡的纳粹势力席卷整个西欧，入侵的威胁迫在眉睫。一群毫无准备的公众，和一个怀疑论国王，时任英国首相的丘吉尔必须面对他最黑暗的时刻——是成为第三帝国的傀儡附属？', '传记/剧情/历史', 'img/movie_img/094706.23447938_270X405X4.jpg', '2017-12-01');
INSERT INTO `movie` VALUES (34, '正义联盟 (2017)', 'Justice League', '扎克·施奈德', '本·阿弗莱克 盖尔·加朵 杰森·莫玛 埃兹拉·米勒', '在对人性重新燃起的希望所驱使，以及被超人的英勇之举所感染，布鲁斯·韦恩与他最新的盟友戴安娜·普林斯一起，组建了一支超强队伍，应对更强劲敌的来袭。虽然这队联盟的各个超级英雄都大有来头——蝙蝠侠、神奇女侠、海王、钢骨与闪电侠，他们首度集结，力挽狂澜，拯救地球免遭灭顶之灾。', '动作/冒险/奇幻', 'img/movie_img/115053.90719531_270X405X4.jpg', '2017-11-17');
INSERT INTO `movie` VALUES (35, '维京：王者之战 (2016)', 'Viking', '安德烈·克拉夫库克', '丹尼拉·科兹洛夫斯基 斯维特拉纳·库德钦科娃 亚历山大·乌斯秋戈夫', '十世纪末，北欧留里克家族继承人基辅大公逝世后，他的三个儿子瓜分了其领地，兄弟之间冲突不断。为了证明自己的血统和身份，小儿子弗拉基米尔开始壮大自己的势力。在不断地战争中，两个哥哥相继去世，弗拉基米尔也通过自己的努力赢得了认同，成为最高统治者。', '动作/战争/剧情', 'img/movie_img/220852.27347241_270X405X4.jpg', '2017-12-01');
INSERT INTO `movie` VALUES (36, '勇往直前 (2017)', 'Only the Brave', '约瑟夫·科辛斯基', '乔什·布洛林 迈尔斯·特勒 杰夫·布里吉斯 詹妮弗·康纳利', '本片根据“格拉尼特山高手”消防队英勇事迹改编，全队共有 19 位救火英雄在扑灭亚利桑那大火时牺牲。电影讲述：在“格拉尼特山高手队”创建之初，队里既有失足青年也有人面临婚姻危机等各种生活问题', '传记/剧情', 'img/movie_img/094840.43794960_270X405X4.jpg', '2017-12-08');
INSERT INTO `movie` VALUES (37, '疯狂特警队 (2017)', 'Raid dingue', '丹尼·伯恩', '爱丽丝·波尔 丹尼·伯恩 米歇尔·布朗 伊万·阿达勒', '影片讲述了法国特警队教官欧仁近来诸事不顺，而偏偏警队又突然空降了一个培训生乔汉娜，这个一心想成为法国特警队第一位女警官的培训生就像一颗定时炸弹，她给特警队惹了各种千奇百怪、层出不穷的麻烦，但每次都歪打正着，和队友一起出色完成各类高难度任务……', '动作/喜剧', 'img/movie_img/094643.13212254_270X405X4.jpg', '2017-12-08');
INSERT INTO `movie` VALUES (38, '假如王子睡着了 (2017)', 'The Dreaming Man', '王郢', '陈柏霖 林允 张云龙 张宇', '王小禾（林允饰）父母早逝，孤身一人在大城市打工，筹钱准备上大学。她暗恋上了青年才俊郑天乐（张云龙饰）。一日，小禾把因故晕倒的天乐送进医院，因一枚钻戒被郑家人误认为是天乐未婚妻。', '爱情/喜剧', 'img/movie_img/103503.50621090_270X405X4.jpg', '2017-12-08');
INSERT INTO `movie` VALUES (39, '双面劫匪 (2015)', 'Heist', '斯科特·曼', '罗伯特·德尼罗 戴夫·巴蒂斯塔 杰弗里·迪恩·摩根 吉娜·卡拉诺', '沃恩（杰弗里·迪恩·摩根饰）为挽救病重女儿被迫成劫匪，与搭档（戴夫·巴蒂斯塔饰）抢劫了赌场大亨教皇（罗伯特·德尼罗）300万美金。不料接应的同伙临阵脱逃，他们被迫劫持了一辆载着孕妇、小孩、老人等一众乘客的巴士。', '动作/犯罪/惊悚', 'img/movie_img/163036.33039601_270X405X4.jpg', '2017-12-08');
INSERT INTO `movie` VALUES (40, '圣诞奇妙公司 (2017)', 'Santa & Cie', '阿兰·夏巴', '阿兰·夏巴 歌什菲·法拉哈尼 皮奥·马麦 奥黛丽·塔图', '影片讲述了阿兰·夏巴饰演的圣诞老人，在所有圣诞精灵全部病倒的情况下，不得不去地球为精灵寻找解药的故事。没想到圣诞老人遭遇雷暴迫降巴黎，从而展开了一场妙趣横生的奇幻冒险。', '家庭/喜剧', 'img/movie_img/102313.76831990_270X405X4.jpg', '2017-12-15');
INSERT INTO `movie` VALUES (42, '至爱梵高·星空之谜 (2017)', 'Loving Vincent', '多洛塔·科别拉 休·韦尔什曼', '道格拉斯·布斯 罗伯特·古拉奇克 杰罗姆·弗林 艾莉诺·汤姆林森', '影片用一封无法投递的信件串联起梵高在去世前最后六周里与他生命中最重要的三个人物之间的秘密，带观众穿越回十九世纪末的欧洲，并陪伴梵高走完他最后的人生。', '动画/传记/犯罪', 'img/movie_img/100134.66130634_270X405X4.jpg', '2017-12-08');
INSERT INTO `movie` VALUES (44, '寻梦环游记 (2017)', 'Coco', '李·昂克里奇 阿德里安·莫里纳', '安东尼·冈萨雷兹 盖尔·加西亚·贝纳尔 本杰明·布拉特 阿兰纳·乌巴奇', '故事讲述小男孩米格(安东尼·冈萨雷斯 配音)一心梦想成为音乐家，更希望自己能和偶像歌神德拉库斯(本杰明·布拉特 配音)一样，创造出打动人心的音乐，但他的家族却世代禁止族人接触音乐。', '动画/冒险/喜剧', 'img/movie_img/172159.79821920_270X405X4.jpg', '2017-11-24');
INSERT INTO `movie` VALUES (46, '公牛历险记 (2017)', 'Ferdinand', '卡洛斯·沙尔丹哈', '约翰·塞纳 凯特·迈克金农 莉莉·戴', '根据曼罗·里夫1936年经典童书改编，讲述西班牙一头名为“费迪南德”的公牛的爆笑历险故事。费迪南德体型健壮，但却心地善良性格温和，它被误认为是危险的野兽，从而被捕送往他乡被逼做一只“斗牛”。为回到家人身边，他不得不踏上了一场终极冒险旅程。', '动画 冒险 喜剧 ', 'img/movie_img/164908.42150165_270X405X4.jpg', '2018-01-19');
INSERT INTO `movie` VALUES (47, '奇迹男孩 (2018)', 'Wonder', '斯蒂芬·卓博斯基', '朱莉娅·罗伯茨 欧文·威尔逊 雅各布·特瑞布雷 诺亚·尤佩', '电影讲述了一个温暖千万家庭的成长故事。10岁的奥吉天生脸部畸形，此前一直在家中和妈妈自学。当他小学五年级时，奥吉进入父母为他精心挑选的学校上学。在这里，奥吉将与校长、老师以及性格迥异的同学相处，他不寻常的外表让他成为同学们讨论的焦点，也给他的校园生活带来了不少难题。幸运的是，在成长过程中，奥吉的父母、姐姐一直是他最坚强的后盾，在他们的支持与关爱下，奥吉凭借自身的勇气、善良、聪敏影响激励了许多身边的人，并收获了友谊、尊重与爱，最终成长为大家心目中的不可思议的“奇迹”。', '家庭 剧情 ', 'img/movie_img/110933.83580463_270X405X4.jpg', '2018-01-19');
INSERT INTO `movie` VALUES (48, '前任3：再见前任 (2017)', 'The Ex-File: The Return of the Exes', '田羽生', '韩庚 郑恺 于文文 曾梦雪', '《前任3：再见前任》主要讲述了，一对好基友孟云（韩庚饰）和余飞（郑恺饰）跟女友都因为一点小事宣告分手，并且“拒绝挽回，死不认错”。两人在夜店、派对与交友软件上放飞人生第二春，大肆庆祝“黄金单身期”，从而引发了一系列好笑的故事。孟云与女友同甘共苦却难逃“五年之痒”，余飞与女友则棋逢敌手相爱相杀无绝期。然而现实的“打脸”却来得猝不及防：一对推拉纠结零往来，一对纠缠互怼全交代。两对恋人都将面对最终的选择：是再次相见？还是再也不见？', '爱情 喜剧 ', 'img/movie_img/093941.51038590_270X405X4.jpg', '2017-12-29');
INSERT INTO `movie` VALUES (49, '太空救援 (2017)', 'Salyut-7', '克里姆·斯彭科', '弗拉季米尔·弗多维琴科夫 柳波芙·阿克肖诺娃 巴维尔·捷列连科 玛丽亚·米罗诺娃', '于外太空的“礼炮7号”空间站意外与地球失去联系，工程师维克托·阿约金和退役宇航员弗拉基米尔·费奥多罗夫临危受命，搭乘联盟号T-13寻找“礼炮7号”的踪迹，当经历宇宙空间对接、太空舱寒流、空间站失火、太阳能充电系统失灵等一系列危机准备返航之时，却被告知空间站即将被击落，一场更大的太空灾难正在袭来......', '动画 剧情 ', 'img/movie_img/160733.51985495_270X405X4.jpg', '2018-01-12');
INSERT INTO `movie` VALUES (50, '忌日快乐 (2017)', 'Happy Death Day', '克里斯托弗·兰敦', '杰西卡·罗瑟 伊瑟尔·布罗萨德 鲁比·莫迪 蕾切尔·马修斯', '一名大学生（杰西卡·罗德 饰演）不断重复经历她被人谋杀的当天，包括所有的细节和可怕的死亡结局，直到追查出杀她凶手的真正身份。', '恐怖 悬疑 ', 'img/movie_img/104525.37064746_270X405X4.jpg', '2018-02-02');
INSERT INTO `movie` VALUES (51, '移动迷宫3：死亡解药 (2018)', 'Maze Runner: The Death Cure', '韦斯·波尔', '迪伦·奥布莱恩 卡雅·斯考达里奥 托马斯·桑斯特 李起弘', '被困在迷宫里三年，成功逃脱的他们，这一次他们要再次回到迷宫。托马斯带领小队成员开展最危险的行动，营救同伴、同时探索从进入迷宫开始就困扰大家的终极问题。', ' 动作 科幻 ', 'img/movie_img/100607.52854928_270X405X4.jpg', '2018-01-26');
INSERT INTO `movie` VALUES (52, '芳华 (2017)', 'Youth', '冯小刚', '黄轩 苗苗 钟楚曦 杨采钰', '影片讲述了在充满理想和激情的部队文工团，一群正值芳华的年轻人在爱情萌发时经历了残酷战争的洗礼。“活雷锋”刘峰（黄轩饰）由于一次触摸事件被集体抛弃，从农村来的何小萍（苗苗饰），因“不良习气”屡次遭到文工团女兵的歧视与排斥，萧穗子（钟楚曦饰）默默暗恋着文工团小号手。三人因命运巧合重逢在硝烟弥漫的战场，昔日文工团的战友林丁丁、郝淑雯、陈灿等人也在时代变革中走上了截然不同的人生命运。', ' 爱情 战争 剧情 ', 'img/movie_img/120450.70160076_270X405X4.jpg', '2017-12-15');
INSERT INTO `movie` VALUES (53, '神秘巨星 (2017)', 'Secret Superstar', '阿瓦提·钱德安', '阿米尔·汗 塞伊拉·沃西 梅·维贾 拉杰·阿晶', '出生在小城镇穆斯林家庭的尹希娅一直有一个梦想：成为全世界最优秀的歌手，可却遭到家暴成性的父亲百般阻挠。懦弱的母亲除了背着父亲悄悄满足尹希娅许多小需求以外，并没有办法实质性的改善她的生活，没有勇气离婚带她离开这个女人不受尊重的地方，更没有勇气支持她的梦想。追梦心切的尹希娅在视频网站上，以“神秘巨星”为名，穿上罩袍上传自己的唱歌视频，不仅被观众喜欢，那些政客、明星、音乐导演也纷纷转发她的视频，甚至音乐导演夏克提•库马尔也向尹希娅抛出了橄榄枝。在夏克提和好朋友钦腾的帮助下，尹希娅开始一步步向梦想靠近…', ' 剧情 喜剧 ', 'img/movie_img/100212.88374572_270X405X4.jpg', '2018-01-19');
INSERT INTO `movie` VALUES (54, '无问西东 (2018)', 'Forever Young', '李芳芳', '章子怡 张震 黄晓明 王力宏', '如果提前了解了你要面对的人生，你是否还会有勇气前来？吴岭澜、沈光耀、王敏佳、陈鹏、张果果，几个年轻人满怀诸多渴望，在四个非同凡响的时空中一路前行。他们在最好的年纪迎来了最残酷的考验，并成就了永不褪色的青春传奇。', ' 剧情 爱情 战争 ', 'img/movie_img/100519.32189201_270X405X4.jpg', '2018-01-12');
INSERT INTO `movie` VALUES (55, '红海行动 (2018)', 'Operation Red Sea', '林超贤', '张译 黄景瑜 海清 杜江', '索马里海域外，中国商船遭遇劫持，船员全数沦为阶下囚。蛟龙突击队沉着应对，潜入商船进行突袭，成功解救全部人质。返航途中，非洲北部伊维亚共和国发生政变，恐怖组织连同叛军攻入首都， 当地华侨面临危险，海军战舰接到上级命令改变航向，前往执行撤侨任务。', ' 动作 剧情 ', 'img/movie_img/150051.13993864_270X405X4.jpg', '2018-02-16');
INSERT INTO `movie` VALUES (56, '祖宗十九代 (2018)', 'The Face Of My Gene', '郭德纲', '岳云鹏 吴京 吴秀波 井柏然', '电影《祖宗十九代》讲述了立志成为作家的土肥圆贝小贝（岳云鹏饰），因外貌原因在现实屡屡碰壁，后在不经意间找到尘封已久的家谱，意外穿越至民国、清朝、明朝、晋朝、上古等年代，与祖先爆笑相遇，亲自调配自己的基因。一路的经历让其收获自信和担当，经历人性的转变而自我成长，重新回到现实的他，生活将发生什么改变…', ' 喜剧 奇幻 ', 'img/movie_img/192237.73059794_270X405X4.jpg', '2018-02-16');
INSERT INTO `movie` VALUES (57, '西游记女儿国 (2018)', 'The Monkey King 3', '郑保瑞', '郭富城 冯绍峰 赵丽颖 小沈阳', '唐僧师徒途经忘川河，因激怒河神而误入西梁女界。闯入其中，众人才发现这个国家只有女性，并且建国以来此地就没来过男性。而且国中立有祖训，将男人视为天敌。典籍中更有预言，指明有朝一日，会有东土而来的僧人带着一只猴子、一头猪和一个小蓝人闯入其中。他们到来之日，便是女儿国走向毁灭之时。', ' 爱情 喜剧 动作 ', 'img/movie_img/094119.78362375_270X405X4.jpg', '2018-02-16');
INSERT INTO `movie` VALUES (58, '唐人街探案2 (2018)', 'Detective Chinatown 2', '陈思诚', '王宝强 刘昊然 肖央 刘承羽', '唐仁(王宝强)以自己举办婚礼为由，把秦风(刘吴然)骗到了纽约，让其参加“世界名侦探大赛”:谁能最快找到完成“唐人街教父”抛出的谜题，谁就能获得巨额奖金。两人在和世界各国侦探们啼笑皆非的较量中，渐渐发现了隐藏在这次挑战背后更大的秘密.....', ' 喜剧 动作 悬疑 ', 'img/movie_img/093620.13079693_270X405X4.jpg', '2018-02-16');
INSERT INTO `movie` VALUES (59, '捉妖记2 (2018)', 'Monster Hunt 2', '许诚毅', '梁朝伟 白百何 井柏然 李宇春', '天荫带着小岚踏上寻父之路，而重回永宁村的胡巴再度被妖王追杀。与此同时，江湖盛传胡巴的重金悬赏令，妖界大军、天师精英、绿林草莽闻风而动，一场腥风血雨即将来临……', ' 喜剧 奇幻 动作 ', 'img/movie_img/175659.93895038_270X405X4.jpg', '2018-02-16');
INSERT INTO `movie` VALUES (60, '马戏之王 (2017)', 'The Greatest Showman', '迈克尔·格雷西', '休·杰克曼 米歇尔·威廉姆斯 扎克·埃夫隆 赞达亚', '电影《马戏之王》是休·杰克曼卸任金刚狼后主演的首部电影，故事讲述了马戏团鼻祖巴纳姆依靠自己无穷想象力，与一群身怀绝技的“怪胎”们，一起开创世界上首个马戏团的精彩故事', ' 剧情 传记 ', 'img/movie_img/105052.60679240_270X405X4.jpg', '2018-02-01');

-- ----------------------------
-- Table structure for remark
-- ----------------------------
DROP TABLE IF EXISTS `remark`;
CREATE TABLE `remark`  (
  `remarkId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `content` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`remarkId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of remark
-- ----------------------------
INSERT INTO `remark` VALUES (16, '有一部分还是很感人的，但是梁朝伟的角色确实不够饱满，很突兀。春春的表演很惊艳。', '2018-02-20 15:18:15');
INSERT INTO `remark` VALUES (17, '很搞笑 胡巴也很可爱。', '2018-02-20 15:20:51');

-- ----------------------------
-- Table structure for umr
-- ----------------------------
DROP TABLE IF EXISTS `umr`;
CREATE TABLE `umr`  (
  `userId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `movieId` int(10) UNSIGNED NOT NULL,
  `remarkId` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`userId`, `movieId`, `remarkId`) USING BTREE,
  INDEX `userId`(`userId`) USING BTREE,
  INDEX `movieId`(`movieId`) USING BTREE,
  INDEX `remarkId`(`remarkId`) USING BTREE,
  CONSTRAINT `movieId` FOREIGN KEY (`movieId`) REFERENCES `movie` (`movieId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `remarkId` FOREIGN KEY (`remarkId`) REFERENCES `remark` (`remarkId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户评论电影关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of umr
-- ----------------------------
INSERT INTO `umr` VALUES (1, 59, 16);
INSERT INTO `umr` VALUES (3, 59, 17);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `userId` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `nickName` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '声色画报', '13512341234', 'img/user_img/20171214151700488.jpg', '13512341234', '2018-02-19 14:42:07');
INSERT INTO `user` VALUES (3, '杏仁糖里的那颗杏仁', '15118326503', 'img/user_img/20171213195339548.jpg', '15118326503', '2018-02-19 14:42:07');
INSERT INTO `user` VALUES (4, '丑鱼尼莫789', '15618123890', 'img/user_img/20171213195638406.jpg', '15618123890', '2018-02-19 14:42:07');
INSERT INTO `user` VALUES (5, '白羊先生', '13003761446', 'img/user_img/20171213194631659.jpg', '13003761446', '2018-02-19 14:42:07');

SET FOREIGN_KEY_CHECKS = 1;
