package com.example.lockscreenapp

import android.content.Intent
import android.graphics.drawable.Icon
import android.service.quicksettings.TileService

class LockTileService : TileService() {

    override fun onStartListening() {
        super.onStartListening()
        qsTile.icon = Icon.createWithResource(this, R.drawable.icon_screen_off)
        qsTile.label = "画面スリープ"
        qsTile.updateTile()
    }

    override fun onClick() {
        super.onClick()
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivityAndCollapse(intent)
    }
}