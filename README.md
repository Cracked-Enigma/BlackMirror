# 🪞 BlackMirror — Android Security Research Lab

> Deliberately vulnerable Android application for practicing mobile security research, reverse engineering, IPC abuse, crypto flaws, JNI exploitation, and runtime instrumentation.

---

## 📌 Overview

**BlackMirror** is a purposely insecure Android application designed as a hands-on playground for:

* Android component exploitation
* client-side authentication bypass
* cryptographic implementation flaws
* exported IPC abuse
* ContentProvider data exfiltration
* JNI memory corruption
* Frida runtime subversion
* persistence techniques

The project simulates real-world Android bug bounty and internal app assessment scenarios.

This is **not a production app**.

It exists purely for education and research.

---

## ⚠️ Disclaimer

This project is provided for **learning and defensive security research only**.

Do not use these techniques on applications or systems you do not own or have explicit permission to test.

The author assumes no responsibility for misuse.

---

## 🧠 What You’ll Practice

* Intent injection
* Exported component abuse
* AES misuse (ECB + hardcoded key)
* Logic authentication bypass
* ContentProvider exploitation
* Native stack overflow
* ELF alignment issues (16 KB pages)
* Frida hooking
* Persistence without root

---

## 🛠 Requirements

* Android Studio (Hedgehog+ recommended)
* Android SDK (API 30+)
* NDK (r26+)
* Emulator or physical device (arm64)
* adb
* jadx
* Frida
* objection (optional)
* lldb / gdb (optional)

---

## 🚀 Build & Run

1. Clone the repository:

```bash
git clone https://github.com/Cracked-Enigma/BlackMirror
cd BlackMirror
```

2. Open in Android Studio.

3. Let Gradle sync.

4. Run on emulator or device.

The app intentionally has **no launcher icon**.

Launch via adb:

```bash
adb shell am start \
-a android.intent.action.VIEW \
-n com.blackmirror/.MainActivity
```

---

## 🧩 Challenge Levels

### Level 1 — Admin Bypass

* Reverse crypto logic
* Generate valid token
* Unlock admin UI via intent

---

### Level 2 — IPC Abuse

* Trigger exported service externally
* Reach debug functionality

---

### Level 3 — ContentProvider Exfiltration

* Dump encrypted notes
* Decrypt offline
* Explain crypto weakness

---

### Level 4 — Native Exploitation

* Trigger JNI stack overflow
* Identify overwrite offset

Bonus:

* demonstrate stack protections
* libc leak

---

### Level 5 — Runtime Subversion

Using Frida:

* bypass admin check
* hook provider decryption

---

### Level 6 — Persistence

Achieve service execution across restarts without modifying APK.

---

### Level 7 — Report

Write a mini security assessment:

* attack surface
* vulnerabilities
* exploit chain
* CVSS estimates
* remediation guidance

---

## 🧬 Vulnerability Classes Included

* Exported Activity
* Exported Service
* Exported ContentProvider
* Hardcoded AES key
* AES ECB mode
* Client-side auth
* Native buffer overflow
* Missing integrity checks
* No permission enforcement

---

## 📂 Project Structure

```
app/
 ├── src/main/java/com/blackmirror/
 │    ├── MainActivity.java
 │    ├── SecretService.java
 │    └── NotesProvider.java
 ├── src/main/cpp/
 │    ├── native-lib.cpp
 │    └── CMakeLists.txt
 └── res/layout/activity_main.xml
```

---

## 🔒 Hardening Exercises (Optional)

After completing the lab:

* restrict exported components
* replace ECB with AES-GCM
* remove hardcoded keys
* add permission checks
* fix JNI overflow
* implement server-side auth

---

## ⭐ Why This Exists

Modern Android security requires understanding:

* IPC internals
* native memory models
* runtime instrumentation
* logic flaws over “classic” crypto

BlackMirror provides a controlled environment to practice all of these.

---

## 🧑‍💻 Author

Built for personal Android security research and skill sharpening.

---

If you’d like, next we can also add:

* `.gitignore` tuned for Android + NDK
* folder tree
* sample exploit folder
* writeup template

Just tell me.

You’re doing this the right way.
