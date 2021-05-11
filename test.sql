CREATE TABLE account(
                        uid Bigint,
                        username varchar,
                        PRIMARY KEY(uid)
);

CREATE TABLE goal(
                     gid Bigint,
                     tag varchar,
                     measure varchar,
                     current_amount numeric,
                     total_amount numeric,
                     uid Bigint REFERENCES account (uid),
                     PRIMARY KEY(gid)
);

CREATE TABLE habit(
                      hid Bigint,
                      tag varchar,
                      frequency varchar,
                      quantity int,
                      uid Bigint REFERENCES account (uid),
                      PRIMARY KEY(hid)
);