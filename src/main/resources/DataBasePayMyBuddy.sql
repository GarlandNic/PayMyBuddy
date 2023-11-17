
DROP DATABASE IF EXISTS paymybuddy;

create database paymybuddy;
use paymybuddy;

create table users(
 USERS_ID integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
 EMAIL varchar(255) NOT NULL,
 NICKNAME varchar(255) NOT NULL,
 PASSWORD varchar(63) NOT NULL,
 BALANCE_IN_CENT integer NOT NULL DEFAULT 0
);

create table friends(
 FRIENDS_ID integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
 USER_ID integer NOT NULL,
 BUDDY_ID integer NOT NULL,
 FOREIGN KEY (USER_ID) REFERENCES users (USERS_ID) ON DELETE CASCADE ON UPDATE CASCADE,
 FOREIGN KEY (BUDDY_ID) REFERENCES users (USERS_ID) ON DELETE CASCADE ON UPDATE CASCADE
);

create table transactions(
 TRANSACTIONS_ID integer NOT NULL AUTO_INCREMENT PRIMARY KEY,
 FRIENDSHIP_ID integer NOT NULL,
 TRANSFER_TIME datetime NOT NULL,
 SENT_VALUE_IN_CENT integer unsigned NOT NULL DEFAULT 0,
 TAXED_FEE_IN_CENT integer unsigned NOT NULL DEFAULT 0,
 DESCRIPTION varchar(1023) DEFAULT '',
 FOREIGN KEY (FRIENDSHIP_ID) REFERENCES friends (FRIENDS_ID) ON DELETE CASCADE ON UPDATE CASCADE
);
 
commit;

