package com.example.demo.util;

import lombok.extern.java.Log;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ReThrowConsoleErrorHandler;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.gen.SourceBuilder;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.*;

import java.util.ArrayList;
import java.util.List;

@Log
public class GenCodeAndDocUtils {

    public static SQLManager getDataSource(String driver, String url, String userName, String password) {
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        // source��Ψһ����Ĳ�����������������Ĭ��ֵ
        SQLManagerBuilder builder = new SQLManagerBuilder(source);
        // ����NameConversion���������ݿ����������»��߷��ʹ��UnderlinedNameConversion
        builder.setNc(new UnderlinedNameConversion());
        // ����һ�������������debug��־��������sql����ִ�в�����ִ��ʱ��
        builder.setInters(new Interceptor[]{new DebugInterceptor()});
        // �������ݿ�ָ�����������ݿ�һ��
        builder.setDbStyle(new MySqlStyle());
        return builder.build();
    }

    public static void initGroupTemplate(String tplPath) {
        //ָ��ģ���ļ�·������������£�����ҪҪָ����Ĭ����classpath:templates����idea�Ļ�����ȡ����
        GroupTemplate groupTemplate = BaseTemplateSourceBuilder.getGroupTemplate();
        String root = System.getProperty("user.dir");

        //����ģ����sql-gen�������ָ���Լ���ģ��·��
        String templatePath = root + tplPath;
        FileResourceLoader resourceLoader = new FileResourceLoader(templatePath);
        groupTemplate.setResourceLoader(resourceLoader);
    }

    /**
     * �������ɣ�����ʵ�壬mapper����
     */
    public static void genCode(SQLManager sqlManager, String basePackageName, String tableName) {
        List<SourceBuilder> sourceBuilder = new ArrayList<>();
        SourceBuilder entityBuilder = new EntitySourceBuilder();
        SourceBuilder mapperBuilder = new MapperSourceBuilder();
        // SourceBuilder mdBuilder = new MDSourceBuilder();

        sourceBuilder.add(entityBuilder);
        sourceBuilder.add(mapperBuilder);
        // sourceBuilder.add(mdBuilder);

        SourceConfig config = new SourceConfig(sqlManager, sourceBuilder);

        config.setPreferDateType(SourceConfig.PreferDateType.LocalDate);

        // ����д����׳��쳣�����Ǽ�������
        EntitySourceBuilder.getGroupTemplate().setErrorHandler(new ReThrowConsoleErrorHandler());

        SimpleMavenProject project = new SimpleMavenProject(basePackageName);
        config.gen(tableName, project);
    }



    /**
     * �������ݿ��ĵ�
     */
    public static void genDoc(SQLManager sqlManager, String basePackageName, String tableName) {
        List<SourceBuilder> sourceBuilder = new ArrayList<>();
        SourceBuilder docBuilder = new MDDocBuilder();

        sourceBuilder.add(docBuilder);

        SourceConfig config = new SourceConfig(sqlManager, sourceBuilder);
        //����д����׳��쳣�����Ǽ�������1
        EntitySourceBuilder.getGroupTemplate().setErrorHandler(new ReThrowConsoleErrorHandler());

        SimpleMavenProject project = new SimpleMavenProject(basePackageName);
        config.gen(tableName, project);
    }




}