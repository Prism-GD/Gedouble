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

Early development. This repository currently documents the launcher project; installation, game detection, loader deployment, and launch integration are not implemented yet.

## Legal and distribution

Gedouble is an independent community project and is not affiliated with or endorsed by RobTop Games. Geometry Dash is proprietary software. Users must obtain the game through legitimate channels. This project will not distribute the game's APK, copyrighted assets, or proprietary game files.

We will study compatible open-source projects and respect their licenses and notices. No third-party code will be copied without verifying its license and complying with its terms.

## Repositories

See [Gedouble-Core](https://github.com/Prism-GD/Gedouble-core) and [Gedouble-SDK](https://github.com/Prism-GD/Gedouble-SDK).

## License

A project license has not yet been selected. Until one is added, do not assume that the repository is licensed for reuse or redistribution.
