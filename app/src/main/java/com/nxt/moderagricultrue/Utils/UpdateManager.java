package com.nxt.moderagricultrue.Utils;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import com.nxt.moderagricultrue.Constants;
import com.nxt.zyl.util.CommonUtils;
import com.nxt.zyl.util.HttpUtils;


public class UpdateManager {
    private Context mcontext;
    private boolean isnet;
    public UpdateManager(Context context) {
        this.mcontext = context;
    }

    public void checkUpdate() {

        isnet = CommonUtils.isNetWorkConnected(mcontext);
        if (isnet) {
            VersionTask versionTask = new VersionTask(mcontext);
            versionTask.execute(Constants.JX12316_VERSION_URL);
        } else {
            Toast.makeText(mcontext,"网络错误", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 更新版本
     */
    class VersionTask extends AsyncTask<String, Void, Boolean> {
        ProgressDialog dialog;
        private int curVersion;
        private int newVersion;

        public VersionTask(Context context) {
            dialog = ProgressDialog.show(context, null, "正在检查更新请稍候...", true, true);
        }

        @Override
        protected void onPostExecute(Boolean result) {

                dialog.dismiss();

            if (result == null) {

                    Toast.makeText(mcontext, "网络超时，请重新获取！", Toast.LENGTH_SHORT).show();

            } else {
                if (result) {

                        getDialog().show();

                } else {

//                        Toast.makeText(mcontext, "此版本为最新版本！", Toast.LENGTH_SHORT).show();

                }
            }
        }

        @Override
        protected Boolean doInBackground(String... params) {
            try {
                curVersion = mcontext.getPackageManager().getPackageInfo(
                        mcontext.getPackageName(), 0).versionCode;
                String v = HttpUtils.getOriginalJSON(params[0]);
                if (v != null && !v.equals("")) {
                    newVersion = Integer.valueOf(HttpUtils
                            .getOriginalJSON(params[0]));
                } else {
                    newVersion = curVersion;
                }

            } catch (NameNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return newVersion > curVersion;
        }
    }

    public synchronized AlertDialog.Builder getDialog() {
        return new AlertDialog.Builder(mcontext)
                // .setIcon(R.drawable.ok)
                .setTitle("软件更新")
                .setMessage("发现程序有更新的版本")
                .setPositiveButton("升级", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        Uri uri = Uri.parse(Constants.JX12316_APKURL);
                        Intent web = new Intent(Intent.ACTION_VIEW, uri);
                        mcontext.startActivity(web);
                    }
                })
                .setNegativeButton("以后再说",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int whichButton) {
                            }
                        });
    }
}
