INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2011-09-22',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'FromSoftware'),
        (SELECT id FROM regions WHERE region_name = 'JP'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (1, (SELECT id FROM platform WHERE platform_name = 'PlayStation 3'));
INSERT INTO releases_platforms (release_id, platform_id) VALUES (1, (SELECT id FROM platform WHERE platform_name = 'Xbox 360'));

INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2011-10-04',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'Namco Bandai Games'),
        (SELECT id FROM regions WHERE region_name = 'NA'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (2, (SELECT id FROM platform WHERE platform_name = 'PlayStation 3'));
INSERT INTO releases_platforms (release_id, platform_id) VALUES (2, (SELECT id FROM platform WHERE platform_name = 'Xbox 360'));

INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2011-10-06',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'Namco Bandai Games'),
        (SELECT id FROM regions WHERE region_name = 'AU'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (3, (SELECT id FROM platform WHERE platform_name = 'PlayStation 3'));
INSERT INTO releases_platforms (release_id, platform_id) VALUES (3, (SELECT id FROM platform WHERE platform_name = 'Xbox 360'));

INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2011-10-07',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'Namco Bandai Games'),
        (SELECT id FROM regions WHERE region_name = 'EU'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (4, (SELECT id FROM platform WHERE platform_name = 'PlayStation 3'));
INSERT INTO releases_platforms (release_id, platform_id) VALUES (4, (SELECT id FROM platform WHERE platform_name = 'Xbox 360'));

INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2012-08-24',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'Namco Bandai Games'),
        (SELECT id FROM regions WHERE region_name = 'NA'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (5, (SELECT id FROM platform WHERE platform_name = 'PC'));

INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2012-10-25',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'FromSoftware'),
        (SELECT id FROM regions WHERE region_name = 'JP'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (6, (SELECT id FROM platform WHERE platform_name = 'PC'));

INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2012-08-23',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'Namco Bandai Games'),
        (SELECT id FROM regions WHERE region_name = 'AU'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (7, (SELECT id FROM platform WHERE platform_name = 'PC'));

INSERT INTO releases (release_date, game_id, publisher_id, region_id)
VALUES ('2012-08-24',
        (SELECT id FROM games WHERE game_name = 'Dark Souls'),
        (SELECT id FROM publishers WHERE publisher_name = 'Namco Bandai Games'),
        (SELECT id FROM regions WHERE region_name = 'EU'));
# platforms
INSERT INTO releases_platforms (release_id, platform_id) VALUES (8, (SELECT id FROM platform WHERE platform_name = 'PC'));
