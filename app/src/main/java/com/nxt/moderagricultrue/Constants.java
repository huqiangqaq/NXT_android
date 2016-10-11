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
    public static final String UPDATE_URL_02 = TEST_URL+"/datum/out/update.jhtml?vcrecno=%s&vccultivar=%s&itype=%s&dtgrant=%s&fnum=%s"+
            "&vcreceiver=%s&vcgrantman=%s";
    public static final String UPDATE_URL_03 = TEST_URL+"/area/creatArea.jhtml?vcrecno=%s&vcoperateuser=%s&vcareadesc=%s";
    public static final String UPDATE_URL_04 = TEST_URL+"/parcel/creatParcel.jhtml?vcrecno=%s&vcareano=%s&vcparceldesc=%s&fparcelarea=%s"+
            "&vcpurpose=%s&fplantarea=%s&vcmanager=%s&istatus=%s&fgisx=%s&fgisy=%s";
    public static final String UPDATE_URL_05 = TEST_URL+"/plot/tidy/update.jhtml?vcrecno=%s&vccutsno=%s&parcel=%s&vcparceldesc=%s"+
            "&dtreadjust=%s&vcreadjustpattern=%s&vcdisinfect=%s";
    //播种记录
    public static final String UPDATE_URL_06 = TEST_URL+"/seed/update.jhtml?vcrecno=%s&vcparceldesc=%s&vccutsno=%s&vcbreed=%s&dtseeddate=%s"+
            "&vcseedpartten=%s&vcseeddensity=%s&vcfertilize=%s&dtfirstirrigate=%s";
    //施肥记录
    public static final String UPDATE_URL_07 = TEST_URL+"/fertilize/update.jhtml?vcrecno=%s&vcparcelno=%s&vcparceldesc=%s&vccutsno=%s"+
            "&dtfertilizedate=%s&vcfertilizenum=%s&vcfertilizerrate=%s";
    //灌溉记录
    public static final String UPDATE_URL_08 = TEST_URL+"/watering/waterUpdate.jhtml?vcrecno=%s&vcparceldesc=%s&vccutsno=%s&dtirrigatedate=%s&fwastewater=%s" +
            "&vcoperateuser=%s&dtoperatedate=%s";
    //病虫害防治
    public static final String UPDATE_URL_09 = TEST_URL+"/diseased/diseasedUpdate.jhtml?vcrecno=%s&vcparceldesc=%s&vcdrug=%s&dtpharmacydate=%s" +
            "&dtpharmacynum=%s&dtpharmacypatten=%s";
    //采收记录
    public static final String UPDATE_URL_10 = TEST_URL+"/recovery/update.jhtml?vcrecno=%s&vcparceldesc=%s&vccutsno=%s&dtrecoverydate=%s"+
            "&vcrecoveryman=%s&vcmaturity=%s&frecovery=%s";
    //茬(批)次记录
    //人员管理
    public static final String UPDATE_URL_12 = TEST_URL+"/user/update.jhtml?vcrecno=%s&id_=%s&name_=%s&sex_=%s&birthday_=%s&filed1_=%s"+
            "filed2_=%s&filed_3=%s";







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
    public static final String ADD_URL_03 = TEST_URL+"/area/creatArea.jhtml?vcorgno=%s&vcoperateuser=%s&vcareadesc=%s";
    //地块信息
    public static final String ADD_URL_04 = TEST_URL+"/parcel/creatParcel.jhtml?vcoperateuser=%s&vcorgno=%s&vcareano=%s&vcparceldesc=%s&fparcelarea=%s"+
            "&vcpurpose=%s&fplantarea=%s&vcmanager=%s&istatus=%s&fgisx=%s&fgisy=%s";
    //地块整理
    public static final String ADD_URL_05 = TEST_URL+"/plot/tidy/create.jhtml?vcoperateuser=%s&vcorgno=%s&vccutsno=%s&parcel=%s&vcparceldesc=%s"+
            "&dtreadjust=%s&vcreadjustpattern=%s&vcdisinfect=%s";
    //播种记录
    public static final String ADD_URL_06 = TEST_URL+"/seed/create.jhtml?vcoperateuser=%s&vcorgno=%s&vcparceldesc=%s&vccutsno=%s&vcbreed=%s&dtseeddate=%s"+
            "&vcseedpartten=%s&vcseeddensity=%s&vcfertilize=%s&dtfirstirrigate=%s";
    //施肥记录
    public static final String ADD_URL_07 = TEST_URL+"/fertilize/create.jhtml?vcoperateuser=%s&vcorgno=%s&vcparcelno=%s&vcparceldesc=%s&vccutsno=%s"+
            "&dtfertilizedate=%s&vcfertilizenum=%s&vcfertilizerrate=%s";
    //灌溉记录
    public static final String ADD_URL_08 = TEST_URL+"/watering/waterAdd.jhtml?vcorgno=%s&vcparceldesc=%s&vccutsno=%s&dtirrigatedate=%s&fwastewater=%s"+
            "vcoperateuser=%s&dtoperatedate=%s";
    //病虫害防治
    public static final String ADD_URL_09 = TEST_URL+"/diseased/diseased.jhtml?vcoperateuser=%s&vcorgno=%s&vcparceldesc=%s&vcdrug=%s&dtpharmacydate=%s"+
            "&dtpharmacynum=%s&dtpharmacypatten=%s";
    //采收记录
    public static final String ADD_URL_10 = TEST_URL+"/recovery/save.jhtml?vcoperateuser=%s&vcorgno=%s&vcparceldesc=%s&vccutsno=%s&dtrecoverydate=%s"+
            "&vcrecoveryman=%s&vcmaturity=%s&frecovery=%s";
    //茬(批)次记录
    //人员管理


    /**
     * 下拉列表
     */
    public static final String SPINNER_URL_01 = TEST_URL+"/parcel/comboboxList.jhtml?vcorgno=";
    public static final String SPINNER_URL_02 = TEST_URL+"/diseased/listParceComboBoxData.jhtml?vcorgno=";
    public static final String Spinner_URL_ZHA = TEST_URL+"/diseased/getseedbatchno.jhtml?parcel=";

}
