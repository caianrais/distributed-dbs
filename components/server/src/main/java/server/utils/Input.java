package server;

class Input
{
    public static boolean isInteger(String value)
    {
        try
        {
            Integer.parseInt(value);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    public static boolean isArgValid(String[] args)
    {
        if(args.length > 1)
        {
            Logger.error("More information received than expected.");
            return false;
        }

        if(!isInteger(args[0]))
        {
            Logger.error("Value '@value' is not an integer type.".replace("@value", args[0]));
            return false;
        }

        int port = Integer.parseInt(args[0]);
        if(port < 5000 || port > 65535)
        {
            Logger.error("Provided port '@port' not in range.".replace("@port", Integer.toString(port)));
            return false;
        }

        return true;
    }
}
