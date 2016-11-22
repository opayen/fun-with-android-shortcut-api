package com.olivierpayen.installuninstallshortcutsample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void createShortcut(View view) {
        Intent shortcutIntent = new Intent(getApplicationContext(), MainActivity.class);
        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "MyShortcut");
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher));

        addIntent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        addIntent.putExtra("duplicate", false);
        getApplicationContext().sendBroadcast(addIntent);
    }

    public void removeShortcut(View view) {
        Intent shortcutIntent = new Intent(getApplicationContext(), MainActivity.class);
        shortcutIntent.setAction(Intent.ACTION_MAIN);

        Intent addIntent = new Intent();
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "MyShortcut");

        addIntent.setAction("com.android.launcher.action.UNINSTALL_SHORTCUT");
        getApplicationContext().sendBroadcast(addIntent);
    }
}
