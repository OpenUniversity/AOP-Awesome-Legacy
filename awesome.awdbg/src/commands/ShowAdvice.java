package commands;

import java.util.List;

import ajdi.Advice;
import ajdi.AdviceApplication;
import ajdi.JoinPoint;
import ajdi.SourceLocation;
import debugger.BreakPointContext;
import debugger.DebuggerException;

public class ShowAdvice extends AbstractCommand 
{

	@Override
	public String getName() {
		return "advice";
	}

	@Override
	public String getHelpShort() {
		return "advice [joinpoint ID]";
	}

	@Override
	public String getHelpFull() {
		return "shows the advice advising the given joinpoint";
	}

	@Override
	public void execute(String params) throws DebuggerException 
	{
		try
		{
			BreakPointContext ctx = remoteCtrl.breakPointContext();
			if(null == ctx)
			{
				throw new DebuggerException("Not at a breakpoint");
			}
			
			if(params.isEmpty())
			{
				System.out.println(getHelpShort());
				return;
			}
			
			int jpId = Integer.parseInt(params);		
			JoinPoint[] jps = remoteCtrl.breakPointContext().getJoinPoints();
			
			if( (jpId > jps.length-1) || (jpId < 0))
			{
				throw new DebuggerException("Invalid joinpoint ID " + params);
			}
			
			System.out.println("Aspect\tType\tSource Location\tOriginal Locations");
			System.out.println("---------------------------------------------------------------------------------");
			
			JoinPoint myJp = jps[jpId];
			List<AdviceApplication> aaps = myJp.advices();
			
			for(AdviceApplication aap : aaps)
			{
				Advice adv = aap.advice();
				String aspectName = adv.declaringType().name();
				
				String advType;
				if(adv.isAfter())
				{
					advType = "AFTER";
				} else if (adv.isAround())
				{
					advType = "AROUND";
				} else
				{
					advType = "BEFORE";
				}
				
				SourceLocation location = adv.location();
				
				System.out.print(aspectName + "\t" + advType + "\t" + location + "\t");
				
				Integer [] lines = adv.sourceLines();
				for(int i=0; i < lines.length; i++)
				{
					System.out.print(lines[i] + " ");
				}
				
				System.out.println();
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println(getHelpShort());
		}
	}

}
