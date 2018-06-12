# FVM(File Version Manager)

## What is FVM??
>* git과 같은 File Version 관리를 위한 형상관리 tool
>* git을 깊게 탐구해 보며 명령어들에 익숙해 지기 위하여 직접 구현을 해본 프로젝트
>* git을 좀 더 쉽게 사용할 수 있도록 사용자 친화적인 UI프로그램을 시도

## How to?
>* commit하였을 때 현재 add 되어 있는 파일들의 copy본을 생성하여 저장함
>* 저장되어있는 이전 버전들의 파일들과 비교하여 변화가 있는 파일들만 저장, 효율적으로 파일을 관리함
>* merge할땐 브랜치가 갈라진 시점부터 commit된 파일들을 비교하며 양쪽 모두에서 변화된 파일이 있을 시 사용자가 한쪽 파일을 선택하게 함

## Function
>* init      :  프로젝트관리를 위한 초기 디렉토리 생성
>* add       :  fvm이 파일을 추적하도록 알려줌
>* commit    :  파일의 현재 상태를 저장함
>* branch    :  새로운 branch를 생성
>* merge     :  master branch와 선택된 branch를 합침
>* checkout  :  원하는 version으로 파일의 상태를 변화

## Development Enviroment
>* 언어 : java 1.8
>* Database : Oracle 11g
>* IDE : 이클립스, IntelliJ
>* 형상관리, 협업 : git, github

## made by
> 김다은, 김상연, 라구원, 서태한
