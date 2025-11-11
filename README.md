---

# 画面スリープ (Fake Screen Off)

This is a small personal Android app I made because the **power button on my phone is broken**.
Normally, I rely on the system’s **auto screen-off** (set to 15 seconds), but I wanted a quicker and more flexible way to make my display *look off* without rooting the phone.

So this app simply does a **“fake death” (mati semu)** — it makes the screen black, sets brightness to 0%, hides navigation and status bars, and then auto-closes itself after 15 seconds.
When it closes, Android’s built-in screen timeout finally kicks in, turning the display off completely — allowing me to wake it again using **fingerprint unlock**.

---

### How it works

* Tap the **Quick Settings tile** labeled `画面スリープ` (“Screen Sleep”), or open the app manually.
* The screen immediately goes black (simulated screen-off).
* After ~15 seconds, the app automatically exits.
* Once it exits, Android turns off the display normally.
* Wake the phone again using **fingerprint** — no power button or root required.

---

### Manual controls

If you need to “wake” the screen again before the 15 seconds are up:

* **Triple-tap** the **top-left corner** of the screen
* Or **press Volume Down** once
* Or **swipe down** from the top of your screen to open the navbar

  * From there, tap **Home** or **Back** to exit the app

---

### Notes

* This doesn’t truly *lock* the phone — it just simulates the display being off.
* Works because the system’s **auto display-off timer** still runs after the app closes.
* Inspired by apps like **WaveUp**, **KinScreen**, **Gravity Screen**, and **Double Tap Screen On/Off (Kimcy929)**.
* Built with **Kotlin + Jetpack Compose**.
* No ads, no unnecessary permissions, just a tiny one-purpose tool.

---

### Quick setup

1. Build & install the APK (`Build > Build APK` in Android Studio).
2. Swipe down to open **Quick Settings**.
3. Tap the **pencil/edit icon** to customize tiles.
4. Drag **「画面スリープ」** into your active tiles.
5. Tap the tile whenever you want to “fake turn off” the screen.

---

### That’s it

Simple. Small. Solves my own problem — and maybe yours too.

---
