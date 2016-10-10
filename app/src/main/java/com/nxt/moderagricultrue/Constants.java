package com.nxt.moderagricultrue;

import com.nxt.moderagricultrue.domain.Test;

import java.net.FileNameMap;

/**
 * Created by xpeng on 2016/9/13.
 */

public class Constants {

    public static final String URL="url";
    public static final String VCRECNO="vcrecno";

    public static final String TEST_URL = "http://192.168.10.8/lp";
    public static final String BASE_URL="http://zs.yxag.gov.cn/lp";//BASE
    public static final String LOGIN_URL=TEST_URL+"/doLoginApp.jhtml?account_=%s&password_=%s";
    public static final String URL_01=BASE_URL+"/datum/buy/listBuyPage.jhtml?limit=10&start=1&page=%s";//购进
    public static final String URL_02=BASE_URL+"/datum/out/listOutPage.jhtml?limit=10&start=1&page=%s";
    public static final String URL_03=BASE_URL+"/area/findByPage.jhtml?limit=10&start=1&page=%s";
    public static final String URL_04=BASE_URL+"/parcel/findByPage.jhtml?limit=10&start=1&page=%s";
    public static final String URL_05=BASE_URL+"/diseased/findByPage.jhtml?limit=10&start=1&page=%s";
    public static final String URL_06=BASE_URL+"/fertilize/list.jhtml?limit=10&start=1&page=%s";
    public static final String URL_07=BASE_URL+"/plot/tidy/listPlotPage.jhtml?limit=10&start=1&page=%s";
    public static final String URL_08=BASE_URL+"/recovery/list.jhtml?limit=10&start=1&page=%s";
    public static final String URL_09=BASE_URL+"/seed/list.jhtml?limit=10&start=1&page=%s";
    public static final String URL_10=BASE_URL+"/watering/findByPage.jhtml?limit=10&start=1&page=%s";
    public static final String URL_11=BASE_URL+"/seedbatch/list.jhtml?limit=10&start=1&page=%s";
    public static final String URL_12=BASE_URL+"/user/info/getUserList.jhtml?limit=10&start=1&page=%s";

    /**
     * 修改
     */
    public static final String UPDATE_URL_01 = TEST_URL+"/datum/buy/update.jhtml?vcrecno=%s&vccultivar=%s&itype=%s&dtbuy=%s&fnum=%s" +
            "&vcbuyman=%s&vcmadecomp=%s&vcsalecomp=%s&dtinstoredate=%s&vcinstoreman=%s";
    public static final String UPDATE_URL_02 = TEST_URL+"/datum/out/update.jhtml?vcopeerateuser=%s&vccultivar=%s&itype=%s&dtgrant=%s&fnum=%s"+
            "&vcreceiver=%s&vcgrantman=%s";
    public static final String UPDATE_URL_03 = TEST_URL+"/area/creatArea.jhtml?vcoperateuser=%s&vcareadesc=%s";
    public static final String UPDATE_URL_04 = TEST_URL+"/parcel/creatParcel.jhtml?vcareano=%s&vcparceldesc=%s&fparcelarea=%s"+
            "vcpurpose=%s&fplantarea=%s&vcmanager=%s&istatus=%s&fgisx=%s&fgisy=%s";
    public static final String UPDATE_URL_05 = TEST_URL+"/plot/tidy/update.jhtml?vccutsno=%s&vcparcelno=%s&vcparceldesc=%s"+
            "&dtreadjust=%s&vcreadjustpattern=%s&vcdisinfect=%s";
    //播种记录
    public static final String UPDATE_URL_06 = TEST_URL+"seed/update.jhtml?vcparceldesc=%s&vccutsno=%s&vcbreed=%s&dtseeddate=%s"+
            "&vcseedpartten=%s&vcseeddensity=%s&vcfertilize=%s&dtfirstirrigate=%s";
    //施肥记录
    public static final String UPDATE_URL_07 = TEST_URL+"fertilize/update.jhtml?vcparcelno=%s&vcparceldesc=%s&vccutsno=%s"+
            "&dtfertilizedate=%s&vcfertilizenum=%s&vcfertilizerrate=%s";
    //灌溉记录
    //病虫害防治
    //采收记录
    //茬(批)次记录
    //人员管理
    /**
     * 新增
     */
    //资料购进
    public static final String ADD_URL_01 = TEST_URL+"/datum/buy/create.jhtml?vcoperateuser=%s&vcorgno=%s&vccultivar=%s&itype=%s&dtbuy=%s&fnum=%s"+
            "&vcbuyman=%s&vcmadecomp=%s&vcsalecomp=%s&dtinstoredate=%s&vcinstoreman=%s";
    //资料发放
    public static final String ADD_URL_02 = TEST_URL+"/datum/out/create.jhtml?vcopeerateuser=%s&vcorgno=%s&vccultivar=%s&itype=%s&dtgrant=%s&fnum=%s"+
            "&vcreceiver=%s&vcgrantman=%s";
    //生产区管理
    public static final String ADD_URL_03 = TEST_URL+"/area/creatArea.jhtml?vcoperateuser=%s&vcareadesc=%s";
    //地块信息
    public static final String ADD_URL_04 = TEST_URL+"/parcel/creatParcel.jhtml?vcoperateuser=%s&vcorgno=%s&vcareano=%s&vcparceldesc=%s&fparcelarea=%s"+
            "&vcpurpose=%s&fplantarea=%s&vcmanager=%s&istatus=%s&fgisx=%s&fgisy=%s";
    //地块整理
    public static final String ADD_URL_05 = TEST_URL+"/plot/tidy/create.jhtml?vcoperateuser=%s&vcorgno=%s&vccutsno=%s&vcparcelno=%s&vcparceldesc=%s"+
            "&dtreadjust=%s&vcreadjustpattern=%s&vcdisinfect=%s";
    //播种记录
    public static final String ADD_URL_06 = TEST_URL+"seed/create.jhtml?vcoperateuser=%s&vcorgno=%s&vcparceldesc=%s&vccutsno=%s&vcbreed=%s&dtseeddate=%s"+
            "&vcseedpartten=%s&vcseeddensity=%s&vcfertilize=%s&dtfirstirrigate=%s";
    //施肥记录
    public static final String ADD_URL_07 = TEST_URL+"fertilize/create.jhtml?vcoperateuser=%s&vcorgno=%s&vcparcelno=%s&vcparceldesc=%s&vccutsno=%s"+
            "&dtfertilizedate=%s&vcfertilizenum=%s&vcfertilizerrate=%s";
    //灌溉记录
    //病虫害防治
    //采收记录
    //茬(批)次记录
    //人员管理
}
