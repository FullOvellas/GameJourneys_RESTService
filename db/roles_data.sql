INSERT INTO roles (role_name, role_type_id) VALUES ('Director', (SELECT id FROM role_types WHERE role_type_name = 'Direction'));
INSERT INTO roles (role_name, role_type_id) VALUES ('Codirector', (SELECT id FROM role_types WHERE role_type_name = 'Direction'));
INSERT INTO roles (role_name, role_type_id) VALUES ('Composer', (SELECT id FROM role_types WHERE role_type_name = 'Music'));
INSERT INTO roles (role_name, role_type_id) VALUES ('Lead composer', (SELECT id FROM role_types WHERE role_type_name = 'Music'));
INSERT INTO roles (role_name, role_type_id) VALUES ('Sound designer', (SELECT id FROM role_types WHERE role_type_name = 'Sound design'));
INSERT INTO roles (role_name, role_type_id) VALUES ('Lead sound designer', (SELECT id FROM role_types WHERE role_type_name = 'Sound design'));
INSERT INTO roles (role_name, role_type_id) VALUES ('Animator', (SELECT id FROM role_types WHERE role_type_name = 'Animation'));
INSERT INTO roles (role_name, role_type_id) VALUES ('Lead game designer', (SELECT id FROM role_types WHERE role_type_name = 'Game design'));