# Shardis Project

[![GitHub release](https://img.shields.io/github/release/shardis/shardis.svg)](https://github.com/shardis/shardis/releases)
[![build status](https://img.shields.io/travis/shardis/shardis/master.svg)](https://travis-ci.org/shardis/shardis)
[![AppVeyor](https://img.shields.io/appveyor/ci/kucharzyk/shardis.svg)](https://ci.appveyor.com/project/kucharzyk/shardis)
[![codecov](https://img.shields.io/codecov/c/github/shardis/shardis/master.svg)](https://codecov.io/gh/shardis/shardis)
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

### Running Spring Boot webapp
```
./gradlew shardis-webapp:bootRun 
```

### Production build
```
./gradlew build 
```

### Docker image build
```
./gradlew buildImage
```

## Yarn tasks

### Angular development server with proxy to spring application
```
cd shardis-frontend
./yarnw run server 
```

### Angular unit tests (chrome)
```
cd shardis-frontend
./yarnw run test:live 
```

### Angular unit tests (chrome - single run)
```
cd shardis-frontend
./yarnw run test
```

### Build documentation
```
cd shardis-frontend
./yarnw run docs
```

## Changelog

<a name="0.1.4"></a>
## [0.1.4](https://github.com/shardis/shardis/compare/v0.1.3...v0.1.4) (2017-07-10)


### Features

* **core:** add configuration for uptodate gradle plugin ([7ed2235](https://github.com/shardis/shardis/commit/7ed2235))
* **core:** add uptodate gradle plugin ([66e6782](https://github.com/shardis/shardis/commit/66e6782))
* **core:** switch to new gradle plugin mechanism ([998362b](https://github.com/shardis/shardis/commit/998362b))
* **core:** update gradle to 4.0.1 ([702d7d4](https://github.com/shardis/shardis/commit/702d7d4))
* **core:** update kotlin to 1.1.3-2 ([88333e0](https://github.com/shardis/shardis/commit/88333e0))
* **core:** use gradle dist with sources ([cd63c61](https://github.com/shardis/shardis/commit/cd63c61))
* **docker:** add basic docker support ([5248797](https://github.com/shardis/shardis/commit/5248797))
* **frontend:** update angular to 4.2.5 ([1438a4d](https://github.com/shardis/shardis/commit/1438a4d))
* **frontend:** update angular to 4.2.6 ([39d3dbd](https://github.com/shardis/shardis/commit/39d3dbd))
* **frontend:** update angular-cli to 1.2.0 ([50fa6e5](https://github.com/shardis/shardis/commit/50fa6e5))
* **frontend:** update clarity to 0.10.0-alpha.3 ([aeaee7d](https://github.com/shardis/shardis/commit/aeaee7d))
* **frontend:** update clarity to 0.10.0-alpha.4 ([23025fd](https://github.com/shardis/shardis/commit/23025fd))
* **frontend:** update ngrx effects to 2.0.4 ([cd34c3f](https://github.com/shardis/shardis/commit/cd34c3f))
* **frontend:** update ngrx store to 2.2.3 ([b28dd0d](https://github.com/shardis/shardis/commit/b28dd0d))
* **frontend:** update yarn to 0.27.5 ([8ec6421](https://github.com/shardis/shardis/commit/8ec6421))


[CHANGELOG.md](CHANGELOG.md)
