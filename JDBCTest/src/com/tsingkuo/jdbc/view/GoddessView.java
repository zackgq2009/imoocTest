package com.tsingkuo.jdbc.view;

import com.tsingkuo.jdbc.base.Goddess;
import com.tsingkuo.jdbc.control.GoddessControl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by johnnykuo on 2017/11/7.
 */
public class GoddessView {

    public static final String CONTEXT = "欢迎内容：“欢迎来到女生禁区：\n " +
            "下面是女神禁区的功能菜单：\n  " +
            "[MAIN/M]:主菜单\n " +
            "[QUERY/Q]:查看全部女神的信息\n " +
            "[GET/G]:查看某位女神的详细信息\n " +
            "[ADD/A]:添加女神信息\n " +
            "[UPDATE/U]:更新女神信息\n " +
            "[DELETE/D]:删除女神信息\n " +
            "[SEARCH/S]:查询女神信息(根据姓名、手机号来查询)\n " +
            "[EXIT/E]:退出女神禁区\n " +
            "[BREAK/B]:退出当前功能，返回主菜单”\n";

    public static final String OPERATION_MAIN="MAIN";
    public static final String OPERATION_QUERY="QUERY";
    public static final String OPERATION_GET="GET";
    public static final String OPERATION_ADD="ADD";
    public static final String OPERATION_UPDATE="UPDATE";
    public static final String OPERATION_DELETE="DELETE";
    public static final String OPERATION_SEARCH="SEARCH";
    public static final String OPERATION_EXIT="EXIT";
    public static final String OPERATION_BREAK="BREAK";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CONTEXT);
        String in = scanner.next().toString();
        String prenious = null;
        GoddessControl goddessControl = null;
        List<Goddess> goddessList = null;
        int mainStep = 1;
        int updateStep = 1;
        int createStep = 1;
        int getStep = 1;
        int delStep = 1;
        int searchStep = 1;

        List<Map<String, Object>> params = new ArrayList<>();
        Map<String, Object> param = null;
        Goddess goddess = null;
        while (true) {
//            String in = scanner.next().toString();
            if (OPERATION_EXIT.equals(in.toUpperCase()) || OPERATION_EXIT.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("退出女神禁区");
                break;
            } else if (OPERATION_BREAK.equals(in.toUpperCase()) || OPERATION_BREAK.substring(0, 1).equals(in.toUpperCase())) {
                System.out.println("您退出了功能，已返回到主菜单");
                prenious = null;
                updateStep = 1;
                createStep =1;
                getStep = 1;
                mainStep = 2;
                delStep = 1;
                searchStep = 1;
                param = null;
                params = null;
            } else if (OPERATION_MAIN.equals(in.toUpperCase()) || OPERATION_MAIN.substring(0, 1).equals(in.toUpperCase()) || OPERATION_MAIN.equals(prenious)) {
                if (mainStep == 1) {
                    System.out.println("欢迎来到主菜单");
                    mainStep++;
                    updateStep = 1;
                    createStep = 1;
                    getStep = 1;
                    delStep = 1;
                    searchStep = 1;
                    param = null;
                    params = null;
                    in = scanner.next();
                } else {
                    System.out.println("欢迎回到主菜单");
                    updateStep = 1;
                    createStep = 1;
                    getStep = 1;
                    delStep = 1;
                    searchStep = 1;
                    param = null;
                    params = null;
                    in = scanner.next();
                }
            } else if (OPERATION_QUERY.equals(in.toUpperCase()) || OPERATION_QUERY.substring(0, 1).equals(in.toUpperCase()) || OPERATION_QUERY.equals(prenious)) {
                System.out.println("系统为您展示前一百为女神信息");
                goddessControl = new GoddessControl();
                goddessList = goddessControl.query();
                if (goddessList != null && goddessList.size() > 0) {
                    for (Goddess g : goddessList
                            ) {
                        System.out.println(g.getId() + " " + g.getUser_name() + " " + g.getAge() + " " + g.getBirthday() + " " + g.getCreate_date() + " " + g.getUpdate_date());
                    }
                } else {
                    System.out.println("暂时还没有你想要的数据，你可以先手动添加一些数据");
                }
            } else if (OPERATION_GET.equals(in.toUpperCase()) || OPERATION_GET.substring(0, 1).equals(in.toUpperCase()) || OPERATION_GET.equals(prenious)) {
                goddessControl = new GoddessControl();
                if (getStep == 1) {
                    System.out.println("请您输入想要查看查看的女神编号：");
                    getStep++;
                    prenious = OPERATION_GET;
                } else {
                    goddess = goddessControl.query(scanner.next());
                    if (goddess != null) {
                        System.out.println("该女神的信息如下：");
                        System.out.println(goddess.getUser_name() + " " + goddess.getAge() + " " + goddess.getBirthday() + " " + goddess.getEmail() + " " + goddess.getMobile());
                        prenious = OPERATION_GET;
                    } else {
                        System.out.println("貌似没有这个女生，要不您重新输入一下女神的编号：");
                        prenious = OPERATION_GET;
                    }
                }
            } else if (OPERATION_ADD.equals(in.toUpperCase()) || OPERATION_ADD.substring(0, 1).equals(in.toUpperCase()) || OPERATION_ADD.equals(prenious)) {
                if (createStep == 1) {
                    System.out.println("请输入你要添加女神的详细信息");
                    goddess = new Goddess();
                    goddessControl = new GoddessControl();
                    System.out.println("她的名字：");
                    goddess.setUser_name(scanner.next());
                    createStep ++;
                    prenious = OPERATION_ADD;
                } else if (createStep == 2) {
                    System.out.println("她的年龄：");
                    goddess.setAge(Integer.valueOf(scanner.next()));
                    createStep ++;
                    prenious = OPERATION_ADD;
                } else if (createStep == 3) {
                    System.out.println("她的生日：例如1990-10-10");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        goddess.setBirthday(simpleDateFormat.parse(scanner.next()));
                        createStep++;
                        prenious = OPERATION_ADD;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("貌似你输入的生日不太正确，请您重新输入!");
                        createStep = 3;
                        prenious = OPERATION_ADD;
                    }
                } else if (createStep == 4) {
                    System.out.println("她的邮箱地址：");
                    goddess.setEmail(scanner.next());
                    createStep++;
                    prenious = OPERATION_ADD;
                } else if (createStep == 5) {
                    System.out.println("她的手机号码：");
                    goddess.setMobile(scanner.next());
                    createStep++;
                    prenious = OPERATION_ADD;
                } else if (createStep == 6) {
                    System.out.println("您的女神大致是这样：" + goddess.getUser_name() + " " + goddess.getAge() + " " + goddess.getBirthday() + " " + goddess.getEmail() + " " + goddess.getMobile());
                    if (goddessControl.create(goddess)) {
                        System.out.println("已经成功帮您添加了女神了");
                        prenious = null;
                        createStep = 1;
                    } else {
                        System.out.println("貌似您的女神我们一时加不进去，要不您再试试看！");
                        prenious = OPERATION_ADD;
                        createStep = 1;
                    }
                }
            } else if (OPERATION_UPDATE.equals(in.toUpperCase()) || OPERATION_UPDATE.substring(0, 1).equals(in.toUpperCase()) || OPERATION_UPDATE.equals(prenious)) {
                if (updateStep == 1) {
                    System.out.println("请输入您想修改的女神编号：");
                    goddessControl = new GoddessControl();
                    goddess = goddessControl.query(scanner.next());
                    if (goddess != null) {
                        System.out.println("请输入修改的名字：");
                        goddess.setUser_name(scanner.next());
                        updateStep++;
                        prenious = OPERATION_UPDATE;
                    } else {
                        System.out.println("貌似您想修改的这位女神不存在");
                        prenious = OPERATION_UPDATE;
                        updateStep = 1;
                    }
                } else if (updateStep == 2) {
                    System.out.println("请输入修改的年龄：");
                    goddess.setAge(Integer.valueOf(scanner.next()));
                    updateStep++;
                    prenious = OPERATION_UPDATE;
                } else if (updateStep == 3) {
                    System.out.println("请输入修改的生日：例如2000-11-11");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    try {
                        goddess.setBirthday(simpleDateFormat.parse(scanner.next()));
                        updateStep++;
                        prenious = OPERATION_UPDATE;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        System.out.println("您输入的生日有些问题！");
                        updateStep = 3;
                        prenious = OPERATION_UPDATE;
                    }
                } else if (updateStep == 4) {
                    System.out.println("请输入修改的邮箱地址：");
                    goddess.setEmail(scanner.next());
                    updateStep++;
                    prenious = OPERATION_UPDATE;
                } else if (updateStep == 5) {
                    System.out.println("请输入修改的手机号码：");
                    goddess.setMobile(scanner.next());
                    updateStep++;
                    prenious = OPERATION_UPDATE;
                } else if (updateStep == 6) {
                    System.out.println("您要修改的女神大致是这样的：" + goddess.getUser_name() + " " + goddess.getAge() + " " + goddess.getBirthday() + " " + goddess.getEmail() + " " + goddess.getMobile());
                    if (goddessControl.update(goddess)) {
                        System.out.println("已经成功帮您修改了女神了");
                        prenious = null;
                        updateStep = 1;
                    } else {
                        System.out.println("貌似您的女神不想让你这么修改，要不您再重试下！");
                        prenious = OPERATION_UPDATE;
                        updateStep = 1;
                    }
                }
            } else if (OPERATION_SEARCH.equals(in.toUpperCase()) || OPERATION_SEARCH.substring(0, 1).equals(in.toUpperCase()) || OPERATION_SEARCH.equals(prenious)) {
                goddessControl = new GoddessControl();
                if (searchStep == 1) {
                    System.out.println("请输入您要查询的信息!");
                    System.out.println("要查询的字段名称：");
                    param.put("name", scanner.next());
                    System.out.println("所要查询的条件：");
                    param.put("rela", scanner.next());
                    System.out.println("所要查询的字段值：");
                    param.put("value", scanner.next());
                    params.add(param);
                    System.out.println("是否还要追加查询条件：1 是，2 不是");
                    if ("1".equals(scanner.next())) {
                        prenious = OPERATION_SEARCH;
                        searchStep = 1;
                    } else if ("2".equals(scanner.next())) {
                        goddessList = goddessControl.query(params);
                        for (Goddess g : goddessList
                                ) {
                            System.out.println(g.getId() + " " + g.getUser_name() + " " + g.getAge() + " " + g.getBirthday() + " " + g.getEmail() + " " + g.getMobile());
                        }
                        prenious = OPERATION_SEARCH;
                        searchStep++;
                    }
                } else {
                    System.out.println("请再一次输入您要查询的信息!");
                    System.out.println("要查询的字段名称：");
                    param.put("name", scanner.next());
                    System.out.println("所要查询的条件：");
                    param.put("rela", scanner.next());
                    System.out.println("所要查询的字段值：");
                    param.put("value", scanner.next());
                    params.add(param);
                    System.out.println("是否还要追加查询条件：1 是，2 不是");
                    if ("1".equals(scanner.next())) {
                        prenious = OPERATION_SEARCH;
                    } else if ("2".equals(scanner.next())) {
                        goddessList = goddessControl.query(params);
                        for (Goddess g : goddessList
                                ) {
                            System.out.println(g.getId() + " " + g.getUser_name() + " " + g.getAge() + " " + g.getBirthday() + " " + g.getEmail() + " " + g.getMobile());
                        }
                        prenious = OPERATION_SEARCH;
                    }
                }
            } else if (OPERATION_DELETE.equals(in.toUpperCase()) || OPERATION_DELETE.substring(0, 1).equals(in.toUpperCase()) || OPERATION_DELETE.equals(prenious)) {
                goddessControl = new GoddessControl();
                if (delStep == 1) {
                    System.out.println("请输入您要删除的女神编号：");
                    int id = Integer.valueOf(scanner.next());
                    goddess = goddessControl.query(Integer.toString(id));
                    if (goddess != null) {
                        if (goddessControl.del(Integer.toString(id))) {
                            System.out.println("该女神已经成功被删除");
                            delStep++;
                            prenious = OPERATION_DELETE;
                        } else {
                            System.out.println("貌似女神并不想被删除，请重新尝试！");
                            prenious = OPERATION_DELETE;
                            delStep = 1;
                        }
                    } else {
                        System.out.println("貌似您想要删除的女神根本就不存在，请重新尝试！");
                        prenious = OPERATION_DELETE;
                        delStep = 1;
                    }
                } else {
                    System.out.println("请输入您还想删除的女神编号：");
                    int id = Integer.valueOf(scanner.next());
                    goddess = goddessControl.query(Integer.toString(id));
                    if (goddess != null) {
                        if (goddessControl.del(Integer.toString(id))) {
                            System.out.println("该女神也已经成功被删除");
                            prenious = OPERATION_DELETE;
                        } else {
                            System.out.println("貌似这位女神不想被删除，请重新尝试！");
                            prenious = OPERATION_DELETE;
                            delStep = 1;
                        }
                    } else {
                        System.out.println("貌似您想要删除的女神根本不存在，请重新尝试！！");
                        prenious = OPERATION_DELETE;
                        delStep = 1;
                    }
                }
            } else {
                System.out.println("您输入的指令有误，请重新输入");
            }
        }
    }

}
