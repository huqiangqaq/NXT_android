package com.nxt.moderagricultrue.domain;

import android.os.*;
import android.os.Parcel;

import java.util.List;

/**
 * Created by huqiang on 2016/10/10.
 */

public class LoginReturn  {


    /**
     * appmsg : 登录成功
     * _default_list_a : [{"id_":"237fa3db16204b4ebc55f1897b995191","cascade_id_":"0.006.004","name_":"播种记录","url_":"seed/init.jhtml","hotkey_":"","parent_id_":"8914d16bd08f408192f8fe0ae3d8b245","is_leaf_":"1","is_auto_expand_":"0","icon_name_":"","status_":"1","parent_name_":"生产记录及管理","vector_":"","sort_no_":1},{"id_":"2a4c060f44d944ea926fe44522ce7b39","cascade_id_":"0","name_":"AOS应用基础平台","parent_id_":"p","is_leaf_":"0","is_auto_expand_":"1","icon_name_":"home.png","status_":"1","parent_name_":"root","sort_no_":1},{"id_":"2f00a1c799c94f1cbacfe97ad944f76c","cascade_id_":"0.006.001","name_":"茬(批)次记录管理","url_":"seedbatch/init.jhtml","hotkey_":"","parent_id_":"8914d16bd08f408192f8fe0ae3d8b245","is_leaf_":"1","is_auto_expand_":"0","icon_name_":"icon140.png","status_":"1","parent_name_":"生产记录及管理","vector_":"","sort_no_":1},{"id_":"501cf9c415d24052bad437d6f316a136","cascade_id_":"0.006.003","name_":"灌溉记录","url_":"watering/index.jhtml","hotkey_":"","parent_id_":"8914d16bd08f408192f8fe0ae3d8b245","is_leaf_":"1","is_auto_expand_":"0","icon_name_":"icon31.gif","status_":"1","parent_name_":"生产记录及管理","vector_":"","sort_no_":2},{"id_":"62d322126cf54c0f8ba1ac945dc6c202","cascade_id_":"0.006.005","name_":"地块整理记录","url_":"plot/tidy/plottidyinit.jhtml","hotkey_":"","parent_id_":"8914d16bd08f408192f8fe0ae3d8b245","is_leaf_":"1","is_auto_expand_":"0","icon_name_":"app_columns.png","status_":"1","parent_name_":"生产记录及管理","vector_":"","sort_no_":1},{"id_":"8914d16bd08f408192f8fe0ae3d8b245","cascade_id_":"0.006","name_":"生产记录及管理","url_":"","hotkey_":"","parent_id_":"2a4c060f44d944ea926fe44522ce7b39","is_leaf_":"0","is_auto_expand_":"1","icon_name_":"folder21.png","status_":"1","parent_name_":"AOS应用基础平台","vector_":"","sort_no_":1},{"id_":"d8d62463a23b4f9d80b897183ad22cab","cascade_id_":"0.006.006","name_":"施肥记录","url_":"fertilize/init.jhtml","parent_id_":"8914d16bd08f408192f8fe0ae3d8b245","is_leaf_":"1","is_auto_expand_":"0","status_":"1","parent_name_":"生产记录及管理","sort_no_":1},{"id_":"ef107ce706ad4726abc7e1de12428e89","cascade_id_":"0.006.002","name_":"采收记录 ","url_":"recovery/init.jhtml","hotkey_":"","parent_id_":"8914d16bd08f408192f8fe0ae3d8b245","is_leaf_":"1","is_auto_expand_":"0","icon_name_":"cut.png","status_":"1","parent_name_":"生产记录及管理","vector_":"","sort_no_":1},{"id_":"fa4826b5e0654d9fa6d89292948488c6","cascade_id_":"0.006.007","name_":"病虫害防治记录","url_":"diseased/index.jhtml","parent_id_":"8914d16bd08f408192f8fe0ae3d8b245","is_leaf_":"1","is_auto_expand_":"0","icon_name_":"bug.png","status_":"1","parent_name_":"生产记录及管理","sort_no_":3}]
     * appcode : 1
     * _order : a3624bd8f9e34d11972979d8e715a8b2
     * _default_string_a : 1
     */

    private String appmsg;
    private int appcode;
    private String _order;
    private String _default_string_a;
    /**
     * id_ : 237fa3db16204b4ebc55f1897b995191
     * cascade_id_ : 0.006.004
     * name_ : 播种记录
     * url_ : seed/init.jhtml
     * hotkey_ :
     * parent_id_ : 8914d16bd08f408192f8fe0ae3d8b245
     * is_leaf_ : 1
     * is_auto_expand_ : 0
     * icon_name_ :
     * status_ : 1
     * parent_name_ : 生产记录及管理
     * vector_ :
     * sort_no_ : 1
     */

    private List<DefaultListABean> _default_list_a;

    public String getAppmsg() {
        return appmsg;
    }

    public void setAppmsg(String appmsg) {
        this.appmsg = appmsg;
    }

    public int getAppcode() {
        return appcode;
    }

    public void setAppcode(int appcode) {
        this.appcode = appcode;
    }

    public String get_order() {
        return _order;
    }

    public void set_order(String _order) {
        this._order = _order;
    }

    public String get_default_string_a() {
        return _default_string_a;
    }

    public void set_default_string_a(String _default_string_a) {
        this._default_string_a = _default_string_a;
    }

    public List<DefaultListABean> get_default_list_a() {
        return _default_list_a;
    }

    public void set_default_list_a(List<DefaultListABean> _default_list_a) {
        this._default_list_a = _default_list_a;
    }

    public static class DefaultListABean implements Parcelable {
        private String id_;
        private String cascade_id_;
        private String name_;
        private String url_;
        private String hotkey_;
        private String parent_id_;
        private String is_leaf_;
        private String is_auto_expand_;
        private String icon_name_;
        private String status_;
        private String parent_name_;
        private String vector_;
        private int sort_no_;

        public String getId_() {
            return id_;
        }

        public void setId_(String id_) {
            this.id_ = id_;
        }

        public String getCascade_id_() {
            return cascade_id_;
        }

        public void setCascade_id_(String cascade_id_) {
            this.cascade_id_ = cascade_id_;
        }

        public String getName_() {
            return name_;
        }

        public void setName_(String name_) {
            this.name_ = name_;
        }

        public String getUrl_() {
            return url_;
        }

        public void setUrl_(String url_) {
            this.url_ = url_;
        }

        public String getHotkey_() {
            return hotkey_;
        }

        public void setHotkey_(String hotkey_) {
            this.hotkey_ = hotkey_;
        }

        public String getParent_id_() {
            return parent_id_;
        }

        public void setParent_id_(String parent_id_) {
            this.parent_id_ = parent_id_;
        }

        public String getIs_leaf_() {
            return is_leaf_;
        }

        public void setIs_leaf_(String is_leaf_) {
            this.is_leaf_ = is_leaf_;
        }

        public String getIs_auto_expand_() {
            return is_auto_expand_;
        }

        public void setIs_auto_expand_(String is_auto_expand_) {
            this.is_auto_expand_ = is_auto_expand_;
        }

        public String getIcon_name_() {
            return icon_name_;
        }

        public void setIcon_name_(String icon_name_) {
            this.icon_name_ = icon_name_;
        }

        public String getStatus_() {
            return status_;
        }

        public void setStatus_(String status_) {
            this.status_ = status_;
        }

        public String getParent_name_() {
            return parent_name_;
        }

        public void setParent_name_(String parent_name_) {
            this.parent_name_ = parent_name_;
        }

        public String getVector_() {
            return vector_;
        }

        public void setVector_(String vector_) {
            this.vector_ = vector_;
        }

        public int getSort_no_() {
            return sort_no_;
        }

        public void setSort_no_(int sort_no_) {
            this.sort_no_ = sort_no_;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(android.os.Parcel dest, int flags) {
            dest.writeString(this.id_);
            dest.writeString(this.cascade_id_);
            dest.writeString(this.name_);
            dest.writeString(this.url_);
            dest.writeString(this.hotkey_);
            dest.writeString(this.parent_id_);
            dest.writeString(this.is_leaf_);
            dest.writeString(this.is_auto_expand_);
            dest.writeString(this.icon_name_);
            dest.writeString(this.status_);
            dest.writeString(this.parent_name_);
            dest.writeString(this.vector_);
            dest.writeInt(this.sort_no_);
        }

        public DefaultListABean() {
        }

        protected DefaultListABean(Parcel in) {
            this.id_ = in.readString();
            this.cascade_id_ = in.readString();
            this.name_ = in.readString();
            this.url_ = in.readString();
            this.hotkey_ = in.readString();
            this.parent_id_ = in.readString();
            this.is_leaf_ = in.readString();
            this.is_auto_expand_ = in.readString();
            this.icon_name_ = in.readString();
            this.status_ = in.readString();
            this.parent_name_ = in.readString();
            this.vector_ = in.readString();
            this.sort_no_ = in.readInt();
        }

        public static final Parcelable.Creator<DefaultListABean> CREATOR = new Parcelable.Creator<DefaultListABean>() {
            @Override
            public DefaultListABean createFromParcel(Parcel source) {
                return new DefaultListABean(source);
            }

            @Override
            public DefaultListABean[] newArray(int size) {
                return new DefaultListABean[size];
            }
        };
    }
}
