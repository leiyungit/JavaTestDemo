package com.msb;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 代码生成器
 */
public class AppCodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        String projectName = "/mybatis_plus_generator";

        // 全局配置
        GlobalConfig gc=new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        // 设置输出路径，也可以使用本地磁盘全路径
        gc.setOutputDir(projectPath + projectName + "/src/main/java");
        gc.setAuthor("leiy") // 作者
        .setFileOverride(true) // 文件覆盖
        .setIdType(IdType.AUTO) // 设置主键生成策略
        .setServiceName("%sService")  // 接口名称 例如：%sBusinessImpl 生成 UserBusinessImpl
        //.setBaseResultMap(true) // 基本结果集合
        //.setBaseColumnList(true) // 设置基本列
        .setControllerName("%sController"); // 控制器名称 例如：%sAction 生成 UserAction

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/mybatisdb?useUnicode=true&useSSL=false&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("123456");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // 设置要包含的表
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        //strategy.setTablePrefix("ptl_"); // 设置表名的前缀
        strategy.setNaming(NamingStrategy.underline_to_camel); // 映射实体时的命名策略


        // 包配置
        PackageConfig pc = new PackageConfig();
        // pc.setModuleName(scanner("模块名"));
        pc.setParent("com.msb") //父包名
        .setEntity("domain").setMapper("mapper").setService("service").setXml("mapper")
         .setController("controller"); //

        mpg.setGlobalConfig(gc).setDataSource(dsc).setStrategy(strategy).setPackageInfo(pc);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };
        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";
        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + projectName + "/src/main/resources/com/msb/mapper" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        mpg.setTemplateEngine(new VelocityTemplateEngine());


        mpg.execute();
    }

    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
}
