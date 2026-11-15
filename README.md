# Gedouble

**An open-source Android launcher and modding platform for Geometry Dash 2.2081.**

Gedouble is an independent project inspired by the architecture and developer experience of existing mod loaders. It is being built as three separate, interoperable repositories:

- **[Gedouble](https://github.com/Prism-GD/Gedouble)** — Android launcher and app interface.
- **[Gedouble-Core](https://github.com/Prism-GD/Gedouble-core)** — native C++ loader and runtime integration.
- **[Gedouble-SDK](https://github.com/Prism-GD/Gedouble-SDK)** — public headers and APIs for mod developers.

## Project targets

- Android only.
- Initial game target: Geometry Dash **2.2081**.
- Native ABIs: `armeabi-v7a` (ARM32) and `arm64-v8a` (ARM64).
- Core language: C++; Assembly may be used selectively where required.
- Build automation: GitHub Actions.

## Current status

The first Android app scaffold is in place:

- Native Kotlin launcher screen.
- Checks whether the official Geometry Dash Android package (`com.robtopx.geometryjump`) is installed.
- Opens the installed game through its regular Android launch intent.
- GitHub Actions workflow builds a debug APK.

**Important:** this is currently a basic launcher prototype. It does not yet install, inject, initialize, or load Gedouble-Core, and it does not load mods. Those capabilities will be developed and tested separately.

## Build

The debug APK is built by the **Android APK** workflow on pushes to `main`, pull requests, or manual workflow dispatch.

To build locally, install JDK 17, Android SDK platform 35, and Gradle 8.9, then run:

```sh
gradle assembleDebug
```

The APK is generated at `app/build/outputs/apk/debug/app-debug.apk`.

## Legal and distribution

Gedouble is an independent community project and is not affiliated with or endorsed by RobTop Games. Geometry Dash is proprietary software. Users must obtain the game through legitimate channels. This project will not distribute the game's APK, copyrighted assets, or proprietary game files.

We will study compatible open-source projects and respect their licenses and notices. No third-party code will be copied without verifying its license and complying with its terms.

## License

A project license has not yet been selected. Until one is added, do not assume that the repository is licensed for reuse or redistribution.
