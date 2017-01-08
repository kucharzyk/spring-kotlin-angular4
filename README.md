# Shardis Project

[![build status](https://img.shields.io/travis/shardis/shardis/master.svg)](https://travis-ci.org/shardis/shardis)
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

## Yarn tasks

### Angular development server with proxy to spring application
```
./yarnw run server 
```

### Angular unit tests (chrome)
```
./yarnw run test:live 
```

### Angular unit tests (chrome - single run)
```
./yarnw run test
```

### Angular unit tests (phantom - single run)
```
./yarnw run test:phantom
```

### Run compdoc
```
./yarnw run docs
```

## Changelog
[CHANGELOG.md](CHANGELOG.md)
