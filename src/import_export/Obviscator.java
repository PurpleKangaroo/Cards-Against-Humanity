package import_export;

/**
 * A class of object that obviscates a String of chars.
 * @author Holt Maki
 * @version CAH1.0
 * @since CAH1.0
 *
 */
public class Obviscator {
	private final static String key0= "%#c;t'SjC~FQU{KG*Jhs)V>I1k([eu8W$PbX]qH2f|T4w o?MO=v}6YnEx5mp3r<\n7_i-B&L0a/R9Z!:\t\"`NAy+ld,.^@zg";
	private final static String key1= "NFnAxyo#cp=:Tl`)$_ ~'iL1ES3\t5]4V[(Bq|7H&8-b@P<mJeGgw{.U^0%Zhs!\"tv9Wk;zrKMjI2O?dXR>,fY/a}u6+CQ\n*";
	private final static String key2= "l$pF/i%u21Q>d\"Lkx7;c:Prz{h\n-teGIfTEyqX.Ab6v[sCJ8}W5<)(3n]m&*So+Z'!NR@^,BY#=0\t`V~jK|U4 wMa_g?H9O";
	private final static String key3= "I&]:@>s*+YW01</!F`$|Sw-Li\"l5aX,TRm3JyVrk[udv;qOgQUZ=A}%bP7{\t6)Ecp?\n(94x'jK2 z8tC~_fnN#o.^MGBHeh";
	private final static String key4= "BP96?1[f7$nl3jC~])*FE'GrVY,&k^>}0RT<#8{+LhU\nzcd%gs-N.!mp aq\"viJwZe5_(tI2`X@K=H|:QobAW/OyuM;x\tS4";
	private final static String key5= "+zJ]oC-@9tj<dy\t*'6Ig(\n5/PV#3a)hAX=?TR >0fBOZ$!|S;~Wm\"lqvu4_GHkL8&riQx{U.ENw2b%`eFp,K7cY^n1}Ms[:";
	private final static String key6= "g!)_/h&@ b3=\tXq]6(8WC1N7%d|\nrZY}ViSlI0.~k+,F[fcyOHu5sJ^xPoELGe{M4KnpB9Qa$AU*\"Rj:<m'tvw-`#?>;2Tz";
	private final static String key7= "pvecE!,\n(bsXaAr&ToC1l{V}BW#Q')+iYL\tmKZUw=4* k63$N>dgzOy]`IJnq97uf@_0/x5%H\"82~^j.-RP;M?[G|St<F:h";
	private final static String key8= "P|q8symn\t=?&N<Ke'ZYdB)!1@MW`4]6 R7SbOV+->{[t09\"_%\nFjzuI.rEv*(l:k}ALwg,QxcJTGip/^2;XHa3h~5$ofUC#";
	private final static String key9= "\t^N2O>Yle:8|o.3A7/GL=j{a]0Vrm$*9ZX~5Fc;CfsEn&(Pp<+k!v#-S,u4\"@\nMxi?_zbyBU%WTKt}' wd1)`6IJ[qQhgRH";
	private final static String[] keys = {key0, key1, key2, key3, key4, key5, key6, key7, key8, key9};
	
	private final static String k0 = "c\"e]DENR!Pj6~>3OST.|U+#l[&Zr)whK=5mWd7zao?'L4(\t`ik0<{\nAXGMpH1xQBfnFg$-VI%q8b/:_J; 2t9,Y@su*^yv}";
	private final static String k1 = "yF$K974(@WUP25 -~XSq[Hh+VtZ?|&#)Nrk6l0p*BesMIdn1OG_v>,/3:mbE]cj{\ngA^QzR8u<oJT`D!a\"%'iY}L;=wf\tx.";
	private final static String k2 = "{(>!ry&#DhU<2lNXcJF6|_`/s=3I:$S@Q% EBM.4wz*o]OK-aufqk}bP0p^\"GZ[Txde\tvYijWtL;A'g7nV+H8\n)~91,m5?R";
	private final static String k3 = "xl6?n~L,|$5)u geVW8S}U!j/M0bKcTB+%hr.4sZdf_{m@#HGo7tY<1y*=:iR9w'>a(`\nqQOp]vEXF3IPD2&\tNz^-\";Ak[J";
	private final static String k4 = "5/TQirtY<SAX\"OLB)NHF|3\t2Z~ac@?x19J'\nPh g!s,bu&o_W{vw7DU-Ky]}m=nzEI^pR6+V#>8f[4.GMl%0`(;jqk:e$*d";
	private final static String k5 = "V\t HB{+t:U|PKeX_jox%?5n-a;DIWZ9qJS0byAc/v2N=!^4df8\"]7FR6'E3\nwiY`GO@#k.[~z<(g)l$&*M1,rpmh}QT>uLs";
	private final static String k6 = "\n6;$IOYw%_]).uvl#!9g&V1UyR ,{7[XHWKB?-\tsbMNdarzoDp0e}|*@54n'>/ZFxm2=T3\"cGt+`:AjE<QP(q^~fLhJS8ki";
	private final static String k7 = "V6m'>0b-%85;,R{hnB@Ga)<2\n!E_j43ou?kv]KwJ1LqMtTlfeF|PS7(YA[*^9$O:Di}x/\tcg#& IyQH.psN+~ZXdzrWU\"=`";
	private final static String k8 = "N+=\t!Q$xhjvcw>}JO4;?E7:FUI_LA|yd<rS]tKl#)%ToHnfi,8\"WMV126\n*{0RsPGgp9a B&q(ue@b'Z/3.[~`m5Y^-kXzD";
	private final static String k9 = "aKs432<O6Pi)kV8|0 ~\th!p+zNE=:G%JwY{5\">1eWfocbq[QuHg.I9UDS^L]lym-v't@jZxM},&/T?n_r$\ndAR`7(*BF#X;";
	private final static String[] k = {k0,k1,k2,k3,k4,k5,k6,k7,k8,k9};
	
	/**
	 * Constructs an object that obviscates text data.
	 * @since CAH1.0
	 */
	public Obviscator()
	{
		
	}
	
	/**
	 * Obviscates a String.
	 * @param obviscateStr The String that will be obviscated.
	 * @return obviscatedStr - The obviscated String.
	 * @since CAH1.0
	 */
	public String obvicscate(String obviscateStr)
	{
		for(int i = 0; i < 10; i++)
		{
			String obviscated = new String();
			for (int n = 0; n < obviscateStr.length(); n++)
			{
				char findChar  = obviscateStr.charAt(n);
				char newChar = k[i].charAt(keys[i].indexOf(findChar));
				obviscated = obviscated + newChar;
			}
			obviscateStr = obviscated;
		}
		String obviscatedStr = obviscateStr;
		return obviscatedStr;
	}
	
	/**
	 * Unobviscates an obviscated String.
	 * @param unObviscateStr the obviscated String that will be unobviscated.
	 * @return unObviscatedStr - the unobviscated String.
	 * @since CAH1.0
	 */
	public String unObviscate(String unObviscateStr)
	{
		for(int i = 10; i > 0; i--)
		{
			String unObviscated = new String();
			for (int n = 0; n < unObviscateStr.length(); n++)
			{
				char findChar  = unObviscateStr.charAt(n);
				char newChar = keys[i].charAt(k[i].indexOf(findChar));
				unObviscated = unObviscated + newChar;
			}
			unObviscateStr = unObviscated;
		}
		String unObviscatedStr = unObviscateStr;
		return unObviscatedStr;
	}
	
}
