package zrj.study.util.ztools;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhongrj
 * @email 329053269@qq.com
 * @date 2017/8/8
 */
public class ParseTxt {

    public static void main(String[] args) throws Exception {

//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
    }

    private static void test5() throws Exception {

        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();

        sb1.append("id, ");
        sb1.append("rid, ");
        sb2.append("#{item.id,jdbcType=INTEGER}, ");
        sb2.append("#{item.rid,jdbcType=VARCHAR}, ");
        Files.lines(Paths.get(ParseTxt.class.getResource("text.txt").getPath().substring(1)), StandardCharsets.UTF_8)
                .forEach(line -> {
                    String[] arrays = line.split("\t");
                    String var = arrays[0].toLowerCase();
                    var = var.substring(0, 1).toUpperCase() + var.substring(1);
                    int i;
                    while ((i = var.indexOf("_")) > 0) {
                        var = var.substring(0, i) + String.valueOf(var.charAt(i + 1)).toUpperCase() + var.substring(i + 2);
                    }
                    sb1.append(String.format("%s, ", arrays[0].toLowerCase()));
                    sb2.append(String.format("#{item.%s,jdbcType=VARCHAR}, ", var));
                });
        sb1.append("create_time");
        sb2.append("#{item.createTime,jdbcType=TIMESTAMP}");


        System.out.print("INSERT INTO xxxxx (");
        System.out.print(sb1.toString());
        System.out.print(")\n" +
                "VALUES\n" +
                "<foreach collection=\"list\" item=\"item\" index=\"index\" separator=\",\">\n" +
                "(");
        System.out.print(sb2.toString());
        System.out.println(")\n" +
                "</foreach>");
    }

    private static void test4() throws Exception {
        Files.lines(Paths.get(ParseTxt.class.getResource("text.txt").getPath().substring(1)), StandardCharsets.UTF_8)
                .forEach(line -> {
                    Matcher matcher = Pattern.compile(".*<(.*)>.*").matcher(line);
                    matcher.find();
                    String className = matcher.group(1);
                    String var = className.substring(0, 1).toLowerCase() + className.substring(1);

                    System.out.println("@Autowired");
                    System.out.printf("private %sDao %sDao;\n", className, var);
                });
    }

    private static void test3() throws Exception {
        Files.lines(Paths.get(ParseTxt.class.getResource("text.txt").getPath().substring(1)), StandardCharsets.UTF_8)
                .forEach(line -> {
                    Matcher matcher = Pattern.compile(".*<(.*)>.*").matcher(line);
                    matcher.find();
                    String className = matcher.group(1);
                    String var = className.substring(0, 1).toLowerCase() + className.substring(1);

                    System.out.printf("List<%s> %ss = response.get%ss();\n", className, var, className);
                    System.out.printf("if (CollectionUtils.isNotEmpty(%ss)) {\n", var);
                    System.out.printf("for (%s %s : %ss) {\n", className, var, var);
                    System.out.printf("%s.setRid(rid);\n", var);
                    System.out.printf("%s.setCreateTime(createTime);\n", var);
                    System.out.printf("}\n");
                    System.out.printf("\t\t\t// %sDao.insertBatch(%ss);\n", var, var);
                    System.out.printf("}\n");

                    System.out.println();

                });
    }

    public static void test2() throws Exception {
        System.out.println("<ITEM>");
        Files.lines(Paths.get(ParseTxt.class.getResource("text.txt").getPath().substring(1)), StandardCharsets.UTF_8)
                .forEach(line -> {
                    String[] arrays = line.split("\t");
                    System.out.printf("\t<%s>xxx</%s>\n", arrays[0], arrays[0]);
                });
        System.out.println("</ITEM>");
    }

    public static void test1() throws Exception {
        System.out.println("record.setNo(String.valueOf(++i));");
        Files.lines(Paths.get(ParseTxt.class.getResource("text.txt").getPath().substring(1)), StandardCharsets.UTF_8)
                .forEach(line -> {
                    String[] arrays = line.split("\t");
                    String var = arrays[0].toLowerCase();
                    var = var.substring(0, 1).toUpperCase() + var.substring(1);
                    int i;
                    while ((i = var.indexOf("_")) > 0) {
                        var = var.substring(0, i) + String.valueOf(var.charAt(i + 1)).toUpperCase() + var.substring(i + 2);
                    }
                    System.out.printf("record.set%s(element.elementText(\"%s\"));\n", var, arrays[0]);
                });
    }

}
