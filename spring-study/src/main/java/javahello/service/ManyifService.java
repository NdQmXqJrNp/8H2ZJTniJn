package javahello.service;

public class ManyifService {

	public boolean todoRefactor(String s) {
		Boolean b = null;
		if ("a".equals(s)) {
			b = true;
		}
		if ("b".equals(s)) {
			b = b || true;
		}
		if ("c".equals(s)) {
			b = b || true;
			return b;
		}
		if ("d".equals(s)) {
			b = false;
			s = "g";
		}
		if ("e".equals(s)) {
			return true;
		}
		// ・・・
		if ("g".equals(s)) {
			b = true;
		}

		if (b == null) {
			b = false;
		}
		return b;
	}
}
