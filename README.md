# Shardis Project

[![GitHub release](https://img.shields.io/github/release/shardis/shardis.svg)]()
[![build status](https://img.shields.io/travis/shardis/shardis/master.svg)](https://travis-ci.org/shardis/shardis)
[![AppVeyor](https://img.shields.io/appveyor/ci/kucharzyk/shardis.svg)](https://ci.appveyor.com/project/kucharzyk/shardis)
[![codecov](https://img.shields.io/codecov/c/github/shardis/shardis/master.svg)](https://codecov.io/gh/shardis/shardis)
[![dependencies](https://img.shields.io/david/shardis/shardis.svg)](https://david-dm.org/shardis/shardis)
[![dev dependencies](https://img.shields.io/david/dev/shardis/shardis.svg)](https://david-dm.org/shardis/shardis)
[![license](https://img.shields.io/github/license/shardis/shardis.svg)](https://github.com/shardis/shardis)


## Note

This project is still a work in progress

## Features

* kotlin and spring boot for backend
* angular with clarity for frontend
* aot support for angular
* gradle as build tool
* node and angular-cli integration via gradle plugin

## Prerequisites

* Java 8 is required
* Google Chrome is required for tests
* Gradle and Node.js and not required

## Gradle tasks

### Running Spring Boot app
```
./gradlew bootRun 
```

### Production build
```
./gradlew build 
```

## Npm tasks

### Angular development server with proxy to spring application
```
./npmw run server 
```

### Angular unit tests (chrome)
```
./npmw run test:live 
```

### Angular unit tests (chrome - single run)
```
./npmw run test
```

### Build documentation
```
./npmw run docs
```

## Changelog

<a name="0.0.6"></a>
## [0.0.6](https://github.com/shardis/shardis/compare/v0.0.5...v0.0.6) (2017-02-26)


### Bug Fixes

* **ci:** fix appveyor build ([bc6b56a](https://github.com/shardis/shardis/commit/bc6b56a))
* **scripts:** fixed npmw.cmd script ([7fbf8c7](https://github.com/shardis/shardis/commit/7fbf8c7))


### Features

* **core:** avoid rebuilding angular app when no changes ([0eea644](https://github.com/shardis/shardis/commit/0eea644))
* **core:** update angular-cli to 1.0.0-rc.0 ([6f92500](https://github.com/shardis/shardis/commit/6f92500))
* **core:** update gradle to 3.4 ([5625708](https://github.com/shardis/shardis/commit/5625708))
* **fronted:** update node to 7.6.0 ([bb3d312](https://github.com/shardis/shardis/commit/bb3d312))
* **fronted:** update npm to 4.3.0 ([3a7ef7e](https://github.com/shardis/shardis/commit/3a7ef7e))
* **frontend:** add npm-check package and upgrade-interactive script ([6c30bfa](https://github.com/shardis/shardis/commit/6c30bfa))
* **frontend:** replace yarn with npm ([b710c4a](https://github.com/shardis/shardis/commit/b710c4a))
* **frontend:** run angular e2e tests after unit tests - also as part of ci build ([b32896f](https://github.com/shardis/shardis/commit/b32896f))
* **frontend:** update angular to 2.4.8 ([b987164](https://github.com/shardis/shardis/commit/b987164))
* **frontend:** update clarity to 0.8.8 ([23a660b](https://github.com/shardis/shardis/commit/23a660b))
* **frontend:** update typescript to 2.2.1 ([07b0254](https://github.com/shardis/shardis/commit/07b0254))
* **frontend:** use ng e2e instead of calling protractor ([97e010f](https://github.com/shardis/shardis/commit/97e010f))


### BREAKING CHANGES

* frontend: Yarn is great but have to many compatibility issues. Now project use npm instead.

[CHANGELOG.md](CHANGELOG.md)
