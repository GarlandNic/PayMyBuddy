
DROP DATABASE IF EXISTS paymybuddy;

create database paymybuddy;
use paymybuddy;

create table users(
 EMAIL varchar(255) PRIMARY KEY,
 PASSWORD varchar(63) NOT NULL,
 BALANCE integer DEFAULT 0
);

create table friends(
 USER_EMAIL varchar(255) NOT NULL,
 FRIEND_EMAIL varchar(255) NOT NULL,
 NICKNAME varchar(15) DEFAULT '',
 PRIMARY KEY (USER_EMAIL, FRIEND_EMAIL),
 FOREIGN KEY (USER_EMAIL) REFERENCES users (EMAIL) ON DELETE CASCADE ON UPDATE CASCADE,
 FOREIGN KEY (FRIEND_EMAIL) REFERENCES users (EMAIL) ON DELETE CASCADE ON UPDATE CASCADE
);

create table transactions(
 SENDER_EMAIL varchar(255) NOT NULL,
 RECIPIENT_EMAIL varchar(255) NOT NULL,
 TRANSFER_TIME datetime NOT NULL,
 VALUE integer unsigned NOT NULL DEFAULT 0,
 FEE integer unsigned NOT NULL DEFAULT 0,
 DESCRIPTION varchar(1023) DEFAULT '',
 PRIMARY KEY (SENDER_EMAIL, RECIPIENT_EMAIL, TRANSFER_TIME),
 FOREIGN KEY (SENDER_EMAIL, RECIPIENT_EMAIL) REFERENCES friends (USER_EMAIL, FRIEND_EMAIL) ON DELETE SET NULL ON UPDATE CASCADE
);
 
commit;


