package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution {
    public static final class Constants {
       public static final String s1 = "Server is not accessible for now.",
                s2 = "User is not authorized.",
                s3 = "User is banned.",
                s4 = "Access is denied.";
    }

    public class ServerNotAccessibleException extends Exception {
        public ServerNotAccessibleException() {
            super(Constants.s1);
        }

        public ServerNotAccessibleException(Throwable cause) {
            super(Constants.s1, cause);
        }
    }

    public class UnauthorizedUserException extends Exception {
        public UnauthorizedUserException() {
            super(Constants.s2);
        }

        public UnauthorizedUserException(Throwable cause) {
            super(Constants.s2, cause);
        }
    }

    public class BannedUserException extends Exception {
        public BannedUserException() {
            super(Constants.s3);
        }

        public BannedUserException(Throwable cause) {
            super(Constants.s3, cause);
        }
    }

    public class RestrictionException extends Exception {
        public RestrictionException() {
            super(Constants.s4);
        }

        public RestrictionException(Throwable cause) {
            super(Constants.s4, cause);
        }
    }
}
