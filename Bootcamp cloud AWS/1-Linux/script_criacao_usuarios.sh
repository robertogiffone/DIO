#!/bin/bash

echo "Criando diretórios..."

mkdir /publico
mkdir /adm
mkdir /back
mkdir /front

echo "Criando grupos de usuários..."

groupadd GRP_ADM
groupadd GRP_BACK
groupadd GRP_FRONT

echo "Criando usuários..."

useradd carlos -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM
useradd maria -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM
useradd jose -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_ADM

useradd gustavo -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_BACK
useradd guilherme -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_BACK
useradd roberto -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_BACK

useradd robson -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_FRONT
useradd victor -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_FRONT
useradd rogerio -m -s /bin/bash -p $(openssl passwd -crypt Senha123) -G GRP_FRONT

echo "Especificando permissões dos diretórios...."

chown root:GRP_ADM /adm
chown root:GRP_BACK /back
chown root:GRP_FRONT /front

chmod 770 /adm
chmod 770 /back
chmod 770 /front
chmod 777 /publico

echo "Fim....."