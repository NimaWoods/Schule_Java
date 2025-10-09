package org.KreisUndRechteck.enums;

public enum FormTyp {
	Kugel("Kugel"),
	Quader("Quader"),
	Tetraeder("Tetraeder");

	private String form;

	FormTyp(String form) {
		this.form = form;
	}

	public String getForm() {
		return form;
	}

	public static FormTyp fromString(String form) {
		for (FormTyp ft : FormTyp.values()) {
			if (ft.form.equalsIgnoreCase(form)) {
				return ft;
			}
		}
		throw new IllegalArgumentException("Ungueltiger Formtyp");
	}
}
