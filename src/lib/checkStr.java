package lib;

/**
 * A set of methods that check whether a string is a substring, a prefix, or a suffix of a string
 */
public class checkStr
{
    /**
     * @param str checked string
     * @param sub assumed substring
     * @return true, if sub is a substring of str, else - false
     */
    public static Boolean isSubstring(String str, String sub)
    {
        int i = 0;
        int j = 0;
        int n = str.length();
        int m = sub.length();
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        boolean eq = false;
        if (n >= m)
        {
            while (!eq && (i <= n - m))
            {
                if (str.charAt(i) != sub.charAt(j))
                {
                    ++i;
                } else
                {
                    eq = true;
                    if (m > 1)
                    {
                        j = 1;
                        while ((j <= m - 1) && eq)
                        {
                            if (str.charAt(i + j) == sub.charAt(j))
                            {
                                ++j;
                            } else
                            {
                                eq = false;
                                j = 0;
                                ++i;
                            }
                        }
                    }
                }
            }
        }
            return eq;
        }

        /**
         * @param str checked string
         * @param sub assuming prefix
         * @return true, if sub is a prefix of str, else - false
         */
        public static Boolean isPrefix (String str, String sub)
        {

            int n = str.length();
            int m = sub.length();
            if (m == 0)
                return true;
            if (n == 0)
                return false;
            int i;
            for (i = 0; (i < m) && (str.charAt(i) == sub.charAt(i)); ++i) ;
            return i == m;
        }

        /**
         * @param str checked string
         * @param sub assuming suffix
         * @return true, if sub is a suffix of str, else - false
         */
        public static Boolean isSuffix (String str, String sub)
        {
            int n = str.length();
            int m = sub.length();
            if (m == 0)
                return true;
            if (n == 0)
                return false;
            int i;
            for (i = 0; (i < m) && (str.charAt(i + n - m) == sub.charAt(i)); ++i) ;
            return i == m;
        }
    }
