package wjc.datastruct;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2018-03-11 16:25
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public interface HashFunction {
    int hash(String s);

    int hash(Object key);
}
