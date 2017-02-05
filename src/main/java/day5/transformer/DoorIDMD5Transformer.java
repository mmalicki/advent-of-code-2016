package day5.transformer;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author mmalicki
 */
public class DoorIDMD5Transformer implements DoorIDTransformer {

    @Override
    public String transform(final String input) {
        return DigestUtils.md5Hex(input);
    }
}
