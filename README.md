# 画面スリープ (Fake Screen Off)

This is a small personal Android app I made because the **power button on my phone is broken**.  
Normally, I rely on the system's **auto screen-off** (set to 15 seconds), but I wanted a quicker and more flexible way to make my display “look off” without rooting the phone.

So this app simply does a **“fake death” (mati semu)** — it makes the screen black, brightness 0%, hides navigation and status bar, then auto-closes itself after 15 seconds.  
When it closes, the system turns off the display normally, and I can wake it again using my **fingerprint**.

---

### How it works

- Tap the **Quick Settings tile** labeled `画面スリープ` (“Screen Sleep”)
- It launches a black overlay (like the screen is off)
- After ~15 seconds, the app closes
- The display goes off (Android auto-sleep triggers)
- I can wake it again using fingerprint (no root needed)

---

### Notes

- This doesn’t really “lock” the device — it just fakes the display off.
- Works because Android auto-sleep still happens after the Activity finishes.
- Inspired by apps like **WaveUp**, **KinScreen**, **Gravity Screen**, or **Double Tap Screen On/Off (Kimcy929)**.
- Built with **Kotlin + Jetpack Compose**.
- No ads, no permissions, just a tiny tool I made for myself.

---

### Quick setup

1. Build & install the app (Android Studio → Build APK)
2. Open your Quick Settings (swipe down)
3. Tap “Edit” or the pencil icon
4. Drag `画面スリープ` into your active tiles

---

### That’s it.
Simple, small, and solves my own problem.
