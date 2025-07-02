CREATE DATABASE `student_management_db`;
USE `student_management_db`;
CREATE TABLE `student`
(
    `Student_Id`    int AUTO_INCREMENT PRIMARY KEY,
    `Full_name`     VARCHAR(100) NOT NULL,
    `Email`         VARCHAR(100) NOT NULL UNIQUE,
    `Phone_Number`  VARCHAR(15)  NOT NULL,
    `Register_Date` DATE         NOT NULL,
    `Status`        bit DEFAULT 1
);

DELIMITER //
CREATE PROCEDURE `get_all_student`()
BEGIN
    SELECT * FROM `student`;
END //

CREATE PROCEDURE `add_student`(`student_name_in` varchar(100), `email_in` varchar(100), `phone_in` varchar(14),
                               `register_in` date)
BEGIN
    INSERT INTO `student`(`full_name`, `email`, `phone_number`, `register_date`)
    VALUES (`student_name_in`, `email_in`, `phone_in`, `register_in`);
END //

CREATE PROCEDURE `get_student_by_id`(`id_in` int)
BEGIN
    SELECT * FROM `student` WHERE `Student_Id` = `id_in`;
END //

CREATE PROCEDURE `update_student`(`Student_Id_in` int, `Full_name_in` varchar(100), `Email_in` varchar(100),
                                  `Phone_Number_in` varchar(15), `register_in` date, `status_in` boolean)
BEGIN
    UPDATE `student`
    SET `Full_name`     =`Full_name_in`,
        `Email`         = `Email_in`,
        `Phone_Number`  = `Phone_Number_in`,
        `Register_Date` = `register_in`,
        `Status`        = `status_in`
    WHERE `Student_Id` = `Student_Id_in`;
END //


CREATE PROCEDURE `delete_student`(`id_del` int)
BEGIN
    DELETE FROM `student` WHERE `Student_Id` = `id_del`;
END //

CREATE PROCEDURE `find_student_by_name`(`name` varchar(100))
BEGIN
    DECLARE `name_search` varchar(100);
    SET `name_search` = CONCAT(CONCAT('%', `name`), '%');
    SELECT * FROM `student` WHERE `Full_name` LIKE `name_search`;
END //
DELIMITER ;