create table users (username VARCHAR(50), 
					passwords VARCHAR(50),
					last_name VARCHAR(50),
                    first_name VARCHAR(50),
                    documents VARCHAR(50)
                    );
INSERT INTO users (username, passwords,first_name,last_name, documents) VALUES ('bestcoder','tempt1','Mcjagger','Adam', 'Forms x2, x7, and x8');
INSERT INTO users (username, passwords,first_name,last_name, documents) VALUES ('sunflower','tempt2','Stacy','Jones', 'Forms x5 and x9');
INSERT INTO users (username, passwords,first_name,last_name, documents) VALUES ('shredder','tempt3','Rachel','Cogan', 'Form x10');
INSERT INTO users (username, passwords,first_name,last_name, documents) VALUES ('moon','tempt4','Ray','Davis', 'Forms x4, x1, x3, and x10');
INSERT INTO users (username, passwords,first_name,last_name, documents) VALUES ('terminator','tempt5','Charles','Thomas', 'Forms x1, and x6');
select * from users;